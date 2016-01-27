package com.frightsystem.dao;

import com.frightsystem.model.Cargo;
import com.frightsystem.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JavaVadim on 27.01.2016.
 */
public class CargoDao {
    private static CargoDao instance;
    private Map<String, Cargo> cargo = new HashMap<>();

    private CargoDao (){}

    public static CargoDao getInstance(){
        if (instance==null){
            instance=new CargoDao();
        } return instance;
    }

    public Cargo getCargo (int id){
        return cargo.get(id);
    }

}
