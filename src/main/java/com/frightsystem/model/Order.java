package com.frightsystem.model;


public class Order {
    private int id;
    private String STATUS; // "ACTIVE", "PERFORMING"; "DONE"
    private String description;
    private double price;

    public int getOrder (){
        return id;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
