package com.example.tripapp;

import java.util.Date;

public class Trip {

    private String user;
    private String location;//start location
    private String destination;
    private String date;
    private String time;

    public String getUser() {
        return user;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate() {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        this.date = date.toString();
    }

    public void setTime() {
        long millis=System.currentTimeMillis();
        java.sql.Time date=new java.sql.Time(millis);
        this.time = date.toString();
    }
}
