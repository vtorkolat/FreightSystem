package com.frightsystem.command.impl.enums;

public enum Page {
    LENDING_PAGE("/easyfreight.ua.do"),
    LOGIN_PAGE("/login.do"),
    REGISTRATION("/registration.do"),
    PROTECTED_PAGE("/protected/my.do"),
    AUTHORIZE_PAGE("/authorize.do"),
    ADDTRANSPORT_PAGE ("/addtransport.do"),
    ADDCARGO_PAGE ("/addcargo.do"),
    SEARCH_PAGE("/search.do"),
    EDITPROFILE_PAGE("/registration/protected/edit.do");



    private static final String REDIRECT_URL = "?redirect=true";
    private String url;

    Page(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getRedirectUrl() {
        return url + REDIRECT_URL;
    }
}
