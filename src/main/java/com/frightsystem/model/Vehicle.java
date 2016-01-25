package com.frightsystem.model;

/**
 * Created by JavaVadim on 24.01.2016.
 */
public class Vehicle {
    private int id;
    private String carModel;
    private String typeOfVehicle;
    private double payload;
    private double volume;

    public String getVehicle (int id){
        return carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
