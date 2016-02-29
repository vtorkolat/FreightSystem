package com.frightsystem.model;

import com.frightsystem.model.enumerations.Role;

import java.util.Date;

public class User {
    private int id;

    private String surname;
    private String name;
    private String thirdname;
    private Role role;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String skype;
    private short phoneNumder;
    private int order_id;




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = Role.fromString(role);
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public short getPhoneNumder() {
        return phoneNumder;
    }

    public void setPhoneNumder(short phoneNumder) {
        this.phoneNumder = phoneNumder;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
