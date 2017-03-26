package com.tasks.task5;

import java.util.ArrayList;
import java.util.Date;

public class TimeServer2 implements Subject {
    private final ArrayList<Observer> observers;
    private Date currentDate;

    public TimeServer2() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentDate);
        }
    }

    public void dateTimeChanged() {
        System.out.println("Server impl 2 called");
        notifyObservers();
    }

    public void setMeasurements(Date currentDate) {
        this.currentDate = currentDate;
        dateTimeChanged();
    }

    public Date getCurrentDate() {
        return currentDate;
    }

}
