package com.jdbc.servlet;

import com.jdbc.bean.Message;
import com.jdbc.bean.User;
import com.jdbc.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author passionlife
 */
public class MessageServlet extends HttpServlet {

    MessageService messageService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("user");
        String pathName=request.getServletPath();
        if(Objects.equals("/addMessagePrompt.do",pathName)){
            //1.从会话中取得User,放到request域中
            request.setAttribute("user",user);
            request.getRequestDispatcher("/WEB-INF/views/biz/add_message.jsp").forward(request,response);
        }else if(Objects.equals("/addMessage.do",pathName)){
            String title=request.getParameter("title");
            String content = request.getParameter("content");
            if(title!=null&&content!=null&&user!=null){
                boolean flag = messageService.addMessage(new Message(user.getId(), user.getUsername(), title, content));
                if(flag){
                    request.getRequestDispatcher("/message/list.do").forward(request,response);
                }else {
                    request.getRequestDispatcher("/WEB-INF/views/biz/add_message.jsp").forward(request,response);
                }
            }else {
                System.out.println("kong ");
            }

        }else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request,response);
        }

    }

    @Override
    public void init() throws ServletException {
        messageService=new MessageService();
        super.init();
    }

    @Override
    public void destroy() {

        super.destroy();
    }
}
