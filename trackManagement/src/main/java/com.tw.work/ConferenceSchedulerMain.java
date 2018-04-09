package com.tw.work;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConferenceSchedulerMain {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Input file with events must be supplied to this program.");
            System.exit(1);
        }

        File inputFile = new File(args[0]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            Conference conference = new ConferenceScheduler().schedule(reader);
            System.out.println(conference);
        } catch (IOException e) {
            System.out.println("Cannot read from input file: " + inputFile.getAbsolutePath());
            System.exit(1);
        }
    }
}
