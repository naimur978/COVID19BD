package com.naimur978.bd_covid19_info.model;

public class PieStatistics {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("cases")
    private int cases;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deaths")
    private int deaths;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("recovered")
    private int recovered;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("todayCases")
    private int todayCases;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("active")
    private int active;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("critical")
    private int critical;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("todayDeaths")
    private int todayDeaths;


    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }
}
