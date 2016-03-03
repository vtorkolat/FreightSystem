package com.frightsystem.command.impl.impl;

import com.frightsystem.command.impl.Command;
import com.frightsystem.command.impl.enums.ContentType;
import com.frightsystem.command.impl.enums.Page;
import com.frightsystem.exceptions.CommandExecutionFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginPageCommand implements Command {

    private static final String INVALID_USER_ATTR = "invalidUser";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType(ContentType.TEXT_HTML.getType());
            String html = "<form method=\"POST\" action=\"" + Page.AUTHORIZE_PAGE.getUrl() + "\">" +
                    "<label for=\"username\">Username:</label><br>" +
                    "<input type=\"text\" id=\"username\" name=\"username\"/><br><br>" +
                    "<label for=\"password\">Username:</label><br>" +
                    "<input type=\"password\" id=\"password\" name=\"password\"/><br><br>" +
                    "<input type=\"submit\" value=\"Log-in\"/><br><br>" +
                    "</form>";

            PrintWriter writer = response.getWriter();
            writer.println(html);
            writer.close();

            return null;
        } catch (IOException e) {
            throw new CommandExecutionFailedException(e.getCause());
        }
    }

    private boolean isUserInvalid(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Object invalidUserFlag = session.getAttribute(INVALID_USER_ATTR);
        session.removeAttribute(INVALID_USER_ATTR);

        return invalidUserFlag != null;
    }
}
