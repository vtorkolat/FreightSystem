package com.frightsystem.enumerations;

/**
 * Created by JavaVadim on 29.01.2016.
 */
public enum Status {
    ACTIVE("ACTIVE"),
    PERFORMING ("PERFORMING"),
    DONE("DONE");

    private String role;

    Status(String name) {
        this.role = name;
    }

    public String getName() {
        return role;
    }
}
