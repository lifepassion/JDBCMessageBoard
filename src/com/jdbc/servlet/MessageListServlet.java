package com.jdbc.servlet;

import com.jdbc.bean.Message;
import com.jdbc.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MessageListServlet extends HttpServlet {

    private MessageService messageService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页码
        String pageStr = request.getParameter("page");
        //页码默认值为1
        int page = 1;
        if (pageStr != null && (!Objects.equals("", pageStr))) {
            page = Integer.parseInt(pageStr);
        }
        //得到全部留言
        List<Message> messages = messageService.getMessages(page, 5);
        int count = messageService.getMessagesCount();
        int last = (count % 5 == 0) ? (count / 5) : (count / 5 + 1);
        request.setAttribute("page",page);
        request.setAttribute("messages",messages);
        request.setAttribute("last",last);
        request.getRequestDispatcher("/WEB-INF/views/biz/message_list.jsp").forward(request,response);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageService();
    }

    @Override
    public void destroy() {
        super.destroy();
        messageService = null;
    }
}
