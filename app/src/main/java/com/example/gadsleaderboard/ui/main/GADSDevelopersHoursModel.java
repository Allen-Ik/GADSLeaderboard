package com.example.gadsleaderboard.ui.main;

public class GADSDevelopersHoursModel {
    private String name;
    private String hours;
    private String country;

    public GADSDevelopersHoursModel(String name, String hours, String country) {
        this.name = name;
        this.hours = hours;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }
}
