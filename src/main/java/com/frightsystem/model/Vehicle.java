package com.frightsystem.model;

import com.frightsystem.model.enumerations.VehicleType;

/**
 * Created by JavaVadim on 24.01.2016.
 */
public class Vehicle {
    private int id;
    private String model;
    private VehicleType type;
    private float payload;
    private float volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public float getPayload() {
        return payload;
    }

    public void setPayload(float payload) {
        this.payload = payload;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}
