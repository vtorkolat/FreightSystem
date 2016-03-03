package com.frightsystem.command.impl.impl;

import com.frightsystem.command.impl.Command;
import com.frightsystem.command.impl.enums.Page;
import com.frightsystem.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizeCommand implements Command {
    private static final String USER_ATTR = "user";
    private static final String EMAIL_ATTR = "email";
    private static final String PASSWORD_ATTR = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = findUser(request);
        String url = null;

        if (user != null) {
            saveUserToSession(user, request);
            url = Page.PROTECTED_PAGE.getRedirectUrl();
        }

        return url;
    }

    private User findUser(HttpServletRequest req) {
        String username = req.getParameter(EMAIL_ATTR);
        String password = req.getParameter(PASSWORD_ATTR);

        if (username != null && password != null) {
            User user = new User(); // Какой класс использовать вместо UserDao ?????

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    private void saveUserToSession(User user, HttpServletRequest req) {
        HttpSession userSession = req.getSession();
        userSession.setAttribute(USER_ATTR, user);
    }
}
