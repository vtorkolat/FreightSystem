package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public enum ActivityField {
    SALES("Торговля"),
    PRODUCTION("Произвоство"),
    AGRICULTURE("Сельское хозйство"),
    SERVICES("Услуги"),
    TRUCKING("Грузоперевозки"),
    OTHER("Другое"),
    DEFAULT("Выбор"),;

    private String activityField;

    ActivityField(String activityField) {
        this.activityField = activityField;
    }

    @Override
    public String toString() {
        return activityField;
    }
}
