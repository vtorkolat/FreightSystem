package com.frightsystem.model;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public class Customer extends User  {

    private Map<String, Order> orders = new HashMap<>();

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }
}
