package com.frightsystem.model;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public class Customer extends User  {
    User customer = new User();
    private String name;
    private String surname;
    private String thirdname;
    private String skype;
    private short phoneNumder;
    private Map<String, Order> orders = new HashMap<>();

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
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

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }
}
