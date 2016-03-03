package com.frightsystem.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/login",
            loadOnStartup = 1)
public class LoginPageServlet extends HttpServlet {
    private static final String WRONG_METHOD_MSG = "Please use GET method to access this page";
    private static final String INVALID_USER_ATTR = "invalidUser";

}
