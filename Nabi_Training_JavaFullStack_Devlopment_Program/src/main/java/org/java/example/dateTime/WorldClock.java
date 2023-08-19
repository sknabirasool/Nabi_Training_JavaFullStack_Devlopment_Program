package org.java.example.dateTime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WorldClock {

    // List of time zones we want to display
    private static final List<String> TIME_ZONES = Arrays.asList(
            "UTC",
            "America/New_York",
            "Europe/London",
            "Asia/Tokyo",
            "Australia/Sydney"
    );

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Schedule the task to run every second
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                displayWorldTime();
            }
        }, 0, 1000);
    }

    public static void displayWorldTime() {
        System.out.println("------ World Clock ------");
        for (String zoneId : TIME_ZONES) {
            LocalTime time = LocalTime.now(ZoneId.of(zoneId));
            System.out.println(zoneId + ": " + time.format(TIME_FORMAT));
        }
        System.out.println("-------------------------\n");
    }
}
