package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public enum VehicleType {
    TIPPER ("Самосвал"),
    GLASSTRANSPORTERS("Стекловоз"),
    CISTERN("Цистерна"),
    EVACUATOR("Эвакуатор"),
    DEFAULT ("Default");

    private String vehicleType;

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public static VehicleType fromString(String vehicleType) {
        for (VehicleType type: VehicleType.values()){
            if(type.vehicleType.equalsIgnoreCase(vehicleType)) return type;
        }
        return TIPPER;
    }

    public String toString() {
        return vehicleType;
    }
}

