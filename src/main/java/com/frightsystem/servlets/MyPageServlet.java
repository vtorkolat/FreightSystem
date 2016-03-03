package com.frightsystem.servlets;

import com.frightsystem.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

@WebServlet(value = "protected/my",
            loadOnStartup = 1)
public class MyPageServlet extends HttpServlet {
    private static final String USER_ATTR = "user";
    private static final String WELCOME_MSG_PATTERN = "Welcome, {0}!";
    private static final String WRONG_METHOD_MSG = "Please use GET method to access this page";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getMethod()) {
            case "GET":
                doGet(req, resp);
                break;
            default:
                System.out.println(WRONG_METHOD_MSG);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    render(request, response);
    }

    private void render(HttpServletRequest req, HttpServletResponse res) {
        try {
            PrintWriter writer = res.getWriter();
            User user = (User) req.getSession().getAttribute(USER_ATTR);
            String html = "<h1>" + MessageFormat.format(WELCOME_MSG_PATTERN, user.getName()) + "</h1>";

            writer.println(html);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
