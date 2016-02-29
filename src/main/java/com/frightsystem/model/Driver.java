package com.frightsystem.model;

import com.frightsystem.model.enumerations.ActivityField;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Driver extends User{

    private String description;


    private String companyName;
    private ActivityField activityField;
    private String numberLicense;
    private Date licenseIssueDate;
    private Map<String, Vehicle> vehicles = new HashMap<>();
    private int vehicle_id;

      public String getDescription() {
        return description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public void setVehicles(String vehicles) {
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}
