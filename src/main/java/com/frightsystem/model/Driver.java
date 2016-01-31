package com.frightsystem.model;

import com.frightsystem.model.enumerations.ActivityField;
import com.frightsystem.model.enumerations.Status;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Driver extends User{
    User driver = new User();
    private int id;
    private Status status;
    private String description;
    private float price;
    private ActivityField activityField;
    private String numberLicense;
    private Date licenseIssueDate;
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ActivityField getActivityField() {
        return activityField;
    }

    public void setActivityField(ActivityField activityField) {
        this.activityField = activityField;
    }

    public String getNumberLicense() {
        return numberLicense;
    }

    public void setNumberLicense(String numberLicense) {
        this.numberLicense = numberLicense;
    }

    public Date getLicenseIssueDate() {
        return licenseIssueDate;
    }

    public void setLicenseIssueDate(Date licenseIssueDate) {
        this.licenseIssueDate = licenseIssueDate;
    }

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
