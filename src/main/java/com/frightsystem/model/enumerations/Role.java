package com.frightsystem.model.enumerations;


public enum Role {
    CUSTOMER("customer"),
    DRIVER("driver"),
    DEFAULT ("Default");

    String name;

    Role(String name){
        this.name = name;
    }

    public static Role fromString(String name) {
        for (Role role: Role.values()){
            if(role.name.equalsIgnoreCase(name)) return role;
        }
        return CUSTOMER;
    }

    public String toString(){
        return name;
    }
}