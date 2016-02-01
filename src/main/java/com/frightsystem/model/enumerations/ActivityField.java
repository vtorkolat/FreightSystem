package com.frightsystem.model.enumerations;

/**
 * Created by JavaVadim on 31.01.2016.
 */
public enum ActivityField {
    SALES("��������"),
    PRODUCTION("�����������"),
    AGRICULTURE("�������� ��������"),
    SERVICES("������"),
    TRUCKING("��������������"),
    OTHER("������"),
    DEFAULT("�����"),;

    private String activityField;

    ActivityField(String activityField) {
        this.activityField = activityField;
    }

    @Override
    public String toString() {
        return activityField;
    }
}
