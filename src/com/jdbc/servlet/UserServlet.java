package com.jdbc.servlet;

import com.jdbc.bean.User;
import com.jdbc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName=request.getServletPath();

        if(Objects.equals("/userInfo.do",pathName)){
            //可以在过滤器里配置
            User user=(User) request.getSession().getAttribute("user");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request,response);
        }else if(Objects.equals("/editUserPrompt.do",pathName)){
            //可以在过滤器里配置
            User user=(User) request.getSession().getAttribute("user");
            request.setAttribute("user",user);
            request.getRequestDispatcher("/WEB-INF/views/biz/edit_user.jsp").forward(request,response);
        }else if (Objects.equals("/editUser.do",pathName)){
            Long id=Long.valueOf(request.getParameter("id"));
            String username=request.getParameter("name");
            String password=request.getParameter("password");
            String realName =request.getParameter("realName");
            String birthday=request.getParameter("birthday");
            String phone=request.getParameter("phone");
            String address=request.getParameter("address");
            User user=new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setReal_name(realName );
            try {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            } catch (Exception e) {
                System.out.println("日期转化失败");
                e.printStackTrace();
            }
            user.setPhone(phone);
            user.setAddress(address);

            Boolean flag=userService.updateUser(user);
            if(flag){
                request.getSession().setAttribute("user",user);
                request.setAttribute("user",user);
                request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request,response);
            }

        }else{
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request,response);
        }


    }

    @Override
    public void init() throws ServletException {
        userService=new UserService();
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
