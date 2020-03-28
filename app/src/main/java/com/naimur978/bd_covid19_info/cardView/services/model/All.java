package com.naimur978.bd_covid19_info.cardView.services.model;

public class All {
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("cases")
    private String cases;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deaths")
    private String deaths;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("recovered")
    private String recovered;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("todayCases")
    private String todayCases;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("active")
    private String active;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("critical")
    private String critical;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("todayDeaths")
    private String todayDeaths;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("casesPerOneMillion")
    private String casesPerOneMillion;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("deathsPerOneMillion")
    private String deathsPerOneMillion;


    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(String casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public String getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(String deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }
}
