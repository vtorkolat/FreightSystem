package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public enum ActivityField {
    SALES("Торговля"),
    PRODUCTION("Произвоство"),
    AGRICULTURE("Сельское хозяйство"),
    SERVICES("Услуги"),
    TRUCKING("Грузоперевозки"),
    OTHER("Другое"),
    DEFAULT("Выбор"),;

    private String activityField;

    ActivityField(String activityField) {
        this.activityField = activityField;
    }

    public static ActivityField fromString (String name){
        for (ActivityField activity: ActivityField.values()){
            if(activity.activityField.equalsIgnoreCase(name))return activity;
        }
        return SALES;
    }

    public String toString() {
        return activityField;
    }
}
