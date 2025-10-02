package com.time.tracker.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ShellComponent
public class TimeCommand {
    private int start = 1;
    private LocalDateTime startDate;

    @ShellMethod("This is a time tracker command")
    public String time() {
        if (start == 1) {
            startDate = LocalDateTime.now();
            start = 2;
            return "===> You have started your work at: " + startDate.format(DateTimeFormatter.ISO_LOCAL_TIME);
        }
        start = 1;
        LocalDateTime now = LocalDateTime.now();
        int totalHours = now.getHour() - startDate.getHour();
        int totalMinutes = now.getMinute() - startDate.getMinute();
        int totalSeconds = now.getSecond() - startDate.getSecond();
        return "===> You have finished your work at: "
                + now.format(DateTimeFormatter.ISO_LOCAL_TIME)
                + "\nTotal hours: " + totalHours + " minutes: " + totalMinutes + " seconds: " + totalSeconds
                + "\nYour works start at: "
                + startDate.format(DateTimeFormatter.ISO_LOCAL_TIME)
                + " End at: "
                + now.format(DateTimeFormatter.ISO_LOCAL_TIME)
                + "\nHave a nice day";
    }
}
