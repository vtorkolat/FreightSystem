package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 29.01.2016.
 */
public enum Status {
    ACTIVE("ACTIVE"),
    PERFORMING ("PERFORMING"),
    DONE("DONE"),
    DEFAULT ("Default");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public static Status fromString(String name) {
        for (Status condition: Status.values()){
         if (condition.status.equalsIgnoreCase(name))return condition;
        }
        return ACTIVE;
    }

    public String toString() {
        return status;
    }
}
