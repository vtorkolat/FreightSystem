package com.frightsystem.model.enumerations;


public enum Role {
    DRIVER("Driver"),
    CUSTOMER("Customer"),
    DEFAULT ("Default");

    private String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
