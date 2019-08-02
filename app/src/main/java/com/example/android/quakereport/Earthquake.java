package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {

    /** Magnitude of the earthquake */
    private double mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the earthquake happened
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    /**
     * @return the magnitude of the earthquake.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return the location of the earthquake.
     */
    public String getLocation() {
        return mLocation;
    }

//    /**
//     * @return the time in milliseconds of the earthquake.
//     */
//    public long getTimeInMilliseconds() {
//        return mTimeInMilliseconds;
//    }

    /**
     * @return the date of the earthquake.
     */
    public String getDate() {
        Date dateObject = new Date(mTimeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        return dateToDisplay;
    }

    /**
     * @return the time of the earthquake.
     */
    public String getTime() {
        Date timeObject = new Date(mTimeInMilliseconds);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(timeObject);
        return timeToDisplay;
    }
}
