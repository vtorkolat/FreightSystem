package com.frightsystem.model;


public class User {
    private int id=1;
    private String email;
    private String password;
    private String role;


    public String getUser(int id) {
        return email;
    }

    public User(String role, int id, String email, String password) {
        this.role = role;
        this.id = id+1;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
