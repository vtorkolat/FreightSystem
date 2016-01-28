package com.frightsystem.enumerations;

/**
 * Created by JavaVadim on 29.01.2016.
 */
public enum Role {
    DRIVER("Driver"), CUSTOMER("Customer");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
