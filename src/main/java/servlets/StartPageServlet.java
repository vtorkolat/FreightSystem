package servlets;

import com.frightsystem.dao.jdbc.CustomerJdbcDao;
import com.frightsystem.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/authorize")
public class StartPageServlet  extends HttpServlet {
    private static final String USER_ATTR = "user";
    private static final String USERNAME_ATTR = "username";
    private static final String PASSWORD_ATTR = "password";

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) {
        if ("POST".equals(req.getMethod())) {
            doPost(req, res);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        User user = findUser(req);

        if (user != null) {
            try {
                authorize(user, req);
                res.sendRedirect("/protected/welcome");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private User findUser(HttpServletRequest req) {
        String username = req.getParameter(USERNAME_ATTR);
        String password = req.getParameter(PASSWORD_ATTR);

        if (username != null && password != null) {
            User user = CustomerJdbcDao.getInstance().getUser(username); // В какой класс мы делаем запрос?

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    private void authorize(User user, HttpServletRequest req) {
        HttpSession userSession = req.getSession(true);
        userSession.setAttribute(USER_ATTR, user);
    }
}
