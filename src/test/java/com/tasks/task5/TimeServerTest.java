package com.tasks.task5;

import java.util.Date;

import org.testng.annotations.Test;

public class TimeServerTest {
    private final TimeServer timeServer = new TimeServer();
    private final TimeServer2 timeServer2 = new TimeServer2();
    private CurrentDateDisplay currentDisplay;

    @Test
    public void testTimeServer() {
        Date date = new Date();
        currentDisplay = new CurrentDateDisplay(timeServer);
        timeServer.setMeasurements(date);
    }

    @Test
    public void testTimeServer2() {
        Date date = new Date();
        currentDisplay = new CurrentDateDisplay(timeServer2);
        timeServer2.setMeasurements(date);
    }
}
