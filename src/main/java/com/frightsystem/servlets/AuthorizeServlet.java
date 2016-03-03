package com.frightsystem.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/authorize")
public class AuthorizeServlet extends HttpServlet {
    private static final String USER_ATTR = "user";
    private static final String USERNAME_ATTR = "username";
    private static final String PASSWORD_ATTR = "password";
    private static final String INVALID_USER_ATTR = "invalidUser";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
