package com.jdbc.servlet;

import com.jdbc.bean.User;
import com.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Objects.equals(request.getServletPath(), "/login.do")) {
            request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request, response);
        }

        if (Objects.equals(request.getServletPath(), "/main.do")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.login(username, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/message/list.do").forward(request, response);
            } else {
                request.getRequestDispatcher("/login.do").forward(request, response);
            }
        }

    }
    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
