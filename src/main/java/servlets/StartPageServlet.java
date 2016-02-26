package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/authorize")
public class StartPageServlet  extends HttpServlet {
    private static final String USER_ATTR = "user";
    private static final String USERNAME_ATTR = "username";
    private static final String PASSWORD_ATTR = "password";
}
