package com.bdoks54.googledistance04view01;

import java.io.Serializable;

public class ClockCity implements Serializable {
    private double lat = 37.5670;
    private double lng = 126.9807;
    private String timezoneId = "Asia/Seoul";
    private String countryName = "Korea";

    public ClockCity(double lat, double lng, String timezoneId, String countryName) {
        this.lat = lat;
        this.lng = lng;
        this.timezoneId = timezoneId;
        this.countryName = countryName;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    @Override
    public String toString() {
        return "ClockCity{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", timezoneId='" + timezoneId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
