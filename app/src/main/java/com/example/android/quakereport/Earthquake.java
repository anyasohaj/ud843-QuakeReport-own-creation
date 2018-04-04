package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 2018.03.25..
 */

public class Earthquake {
    private double mag;
    private String location;
    private long date;
    private String formattedDate;
    private String formattedTime;
    private String url;

    public Earthquake(double mag, String location, long date, String url) {
        this.mag = mag;
        this.location = location;
        this.date = date;
        this.url = url;
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormatterDate = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat dateFormatterTime = new SimpleDateFormat("hh:mm");
        formattedDate= dateFormatterDate.format(dateObject);
        formattedTime = dateFormatterTime.format(dateObject);
    }

    public double getMag() {
        return mag;
    }

    public String getLocation() {
        return location;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public String getUrl() {
        return url;
    }
}
