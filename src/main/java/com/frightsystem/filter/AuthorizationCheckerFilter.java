package com.frightsystem.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/protected/*")
public class AuthorizationCheckerFilter implements Filter {
    private static final String USER_ATTR = "user";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    private boolean isUserAuthorized (ServletRequest request){
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession userSession = req.getSession();
        return userSession.getAttribute(USER_ATTR) != null;
    }

    private void forwardToLoginPage (ServletRequest request, ServletResponse response){

    }

    @Override
    public void destroy() {}

}
