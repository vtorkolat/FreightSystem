package com.frightsystem.command.impl.enums;

public enum ContentType {
    TEXT_HTML("text/html");

    private String type;

    ContentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
