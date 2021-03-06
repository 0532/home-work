package com.tw.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import static com.tw.work.util.Config.*;


public final class ConferenceScheduler {
    public ConferenceScheduler() {}

    public Conference schedule(BufferedReader input) throws IOException {
        List<Event> events = new ArrayList<Event>();
        for (String line; (line = input.readLine()) != null;) {
            line = line.trim();
            Event event = parseInputLine(line);
            if (event == null) {
                continue;
            }
            events.add(event);
        }

        Conference conference = new Conference();
        while (events.size() != 0) {
            Slot morningSlot = new Slot(MORNING_SLOT_DURATION, MORNING_SLOT_START_TIME);
            fillSlotWithEvents(morningSlot, events);
            Slot lunchSlot = new Slot(LUNCH_SLOT_DURATION, LUNCH_SLOT_START_TIME);
            lunchSlot.addEvent(new Event("Lunch", LUNCH_SLOT_DURATION, DurationUnit.MINUTES));
            Slot afternoonSlot = new Slot(AFTERNOON_SLOT_DURATION, AFTERNOON_SLOT_START_TIME);
            fillSlotWithEvents(afternoonSlot, events);
            Event networkingEvent = new Event(NETWORKING_EVENT_NAME, NETWORKING_EVENT_DURATION,
                    NETWORKING_EVENT_DURATION_UNIT);
            Slot networkingSlot = new Slot(networkingEvent.getDurationInMinutes(),
                    NETWORKING_EVENT_MIN_START_TIME);
            networkingSlot.addEvent(networkingEvent);
            afternoonSlot.addSupplementSlot(networkingSlot);
            Track track = new Track();
            track.addSlot(morningSlot);
            track.addSlot(lunchSlot);
            track.addSlot(afternoonSlot);
            conference.addTrack(track);
        }

        return conference;
    }

    private static void fillSlotWithEvents(Slot slot, List<Event> events) {
        for (Iterator<Event> iter = events.iterator(); iter.hasNext();) {
            Event event = iter.next();
            if (slot.hasRoomFor(event)) {
                slot.addEvent(event);
                iter.remove();
            }
        }
    }

    private static Event parseInputLine(String line) {
        if (line.length() == 0) {
            return null;
        }

        Matcher match = INPUT_LINE_PATTERN.matcher(line);
        if (match.find() == false) {
            System.out.println("Invalid input line: " + line);
            return null;
        }

        DurationUnit unit;
        if (match.group(EVENT_DURATION_UNIT_INDEX).equalsIgnoreCase("min")) {
            unit = DurationUnit.MINUTES;
        } else {
            unit = DurationUnit.LIGHTENING;
        }

        String name = match.group(EVENT_NAME_INDEX);
        String durationInString = match.group(EVENT_DURATION_INDEX);
        if (durationInString == null) {
            durationInString = "1";
        }
        int duration = Integer.parseInt(durationInString);

        Event event = new Event(name, duration, unit);
        if (event.getDurationInMinutes() > MAX_EVENT_DURATION) {
            System.out.println("Duration of event '" + name + "' is more than the maximum duration"
                    + " allowed for an event. Dropping this event for scheduling.");
            return null;
        }

        return event;
    }
}
