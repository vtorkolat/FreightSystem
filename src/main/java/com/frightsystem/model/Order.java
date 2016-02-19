package com.frightsystem.model;


import com.frightsystem.model.enumerations.Status;

import java.util.HashMap;
import java.util.Map;

public class Order  {
    private int id;
    private Status status;
    private String description;
    private float price;
    private Map<String, Cargo> cargo = new HashMap<>();
    private Map<String, Route> route = new HashMap<>();

    public int getId() {
        return id;
    }

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

    public Map<String, Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(Map<String, Cargo> cargo) {
        this.cargo = cargo;
    }

    public Map<String, Route> getRoute() {
        return route;
    }

    public void setRoute(Map<String, Route> route) {
        this.route = route;
    }
}
