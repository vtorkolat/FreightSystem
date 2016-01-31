package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 29.01.2016.
 */
public enum Status {
    ACTIVE("ACTIVE"),
    PERFORMING ("PERFORMING"),
    DONE("DONE"),
    DEFAULT ("Default");

    private String role;

    Status(String name) {
        this.role = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "role='" + role + '\'' +
                '}';
    }
}
