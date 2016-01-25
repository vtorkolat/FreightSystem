package com.frightsystem.model;

/**
 * Created by JavaVadim on 24.01.2016.
 */
public class Cargo {
    private int Id;
    private String type;
    private String description;
    private double weight;
    private double volume;


    public void setType(String type) {
        this.type = type;
    }

    public String getCargo (int id){
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
