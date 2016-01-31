package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public enum VehicleType {
    GLASSTRANSPORTERS("Стекловоз"),
    CISTERN("Цистерна"),
    EVACUATOR("Эвакуатор"),
    TIPPER ("Самосвал"),
    DEFAULT ("Default");

    private String vehicleType;

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "name='" + vehicleType + '\'' +
                '}';
    }
}

