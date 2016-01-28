package com.frightsystem.model;


import com.frightsystem.enumerations.Status;

public class Order  {
    private int id;
    private static Status status;
    private String description;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status status) {
        Order.status = status;
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

}
