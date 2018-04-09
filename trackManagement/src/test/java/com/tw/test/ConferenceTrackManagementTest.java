package com.tw.test;

import com.tw.work.Conference;
import com.tw.work.ConferenceScheduler;
import org.junit.Test;
import com.tw.test.util.FileUtil;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ConferenceTrackManagementTest {
    @Test
    public void testConferenceTrackManagementMultipleFullDayEvents() throws IOException {
    	testConferenceTrackManagement("/input_file");
    }

    @Test
    public void testConferenceTrackManagementMultipleDayLessEvents() throws IOException {
    	testConferenceTrackManagement("/input_file_less_events");
    }

    @Test
    public void testConferenceTrackManagementSingleDayEvents() throws IOException {
    	testConferenceTrackManagement("/input_file_single_day_events");
    }

    private void testConferenceTrackManagement(String inputFile) throws IOException {
    	Conference conference = new ConferenceScheduler().schedule(
    			FileUtil.getBufferedReaderForResourceFile(inputFile, this));
    	assertTrue(FileUtil.contentEquals(getExpectedOutputFile(inputFile),
    			conference.toString(), this));
    }

    private String getExpectedOutputFile(String inputFile) {
    	return inputFile + "_expected";
    }
}
