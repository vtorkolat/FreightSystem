package com.frightsystem.model;

import java.sql.Time;
import java.util.Date;


public class Route {
    private int id;
    private String loadingAdress;
    private String unloadingAdress;
    private Date loadingDate;
    private Time loadingTime;

    @Override
    public String toString() {
        return "Route{" +
                "loadingAdress='" + loadingAdress + '\'' +
                ", unloadingAdress='" + unloadingAdress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoadingAdress() {
        return loadingAdress;
    }

    public void setLoadingAdress(String loadingAdress) {
        this.loadingAdress = loadingAdress;
    }

    public String getUnloadingAdress() {
        return unloadingAdress;
    }

    public void setUnloadingAdress(String unloadingAdress) {
        this.unloadingAdress = unloadingAdress;
    }

    public Date getDate() {
        return loadingDate;
    }

    public void setDate(Date date) {
        this.loadingDate = date;
    }

    public Time getTime() {
        return loadingTime;
    }

    public void setTime(Time time) {
        this.loadingTime = time;
    }
}
