package com.tasks.task5;

import java.util.Date;

public class CurrentDateDisplay implements DisplayElement, Observer {
    private Date currentDate;
    private final Subject timeServer;

    public CurrentDateDisplay(Subject timeServer) {
        this.timeServer = timeServer;
        timeServer.registerObserver(this);
    }

    @Override
    public void update(Date currentDate) {
        this.currentDate = currentDate;
        display();

    }

    @Override
    public void display() {
        System.out.println("Current date and time: " + currentDate);

    }

}
