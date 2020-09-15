package com.example.gadsleaderboard.ui.main;

public class GADSDevelopersIqSkillsModel {
    private String name;
    private String score;
    private String country;

    public GADSDevelopersIqSkillsModel(String name, String score, String country) {
        this.name = name;
        this.score = score;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }
}
