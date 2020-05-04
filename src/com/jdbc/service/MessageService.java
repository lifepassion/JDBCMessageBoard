package com.jdbc.service;

import com.jdbc.bean.Message;
import com.jdbc.dao.MessageDao;

import java.util.Date;
import java.util.List;

/**
 * 消息的Service
 * @author passionlife
 */
public class MessageService {

    private MessageDao messageDao;
    public MessageService(){
        messageDao=new MessageDao();
    }

    /**
     * 分页查询留言信息
     * @param page
     * @param pageSize
     * @return每一页留言
     */
    public List<Message> getMessages(int page,int pageSize){
        return messageDao.getMessages(page,pageSize);
    }

    /**
     * 计算所有留言的个数
     * @return所有留言个数
     */
    public int getMessagesCount(){
        return messageDao.getMessagesCount();
    }

    /**
     * 添加message
     * @param message
     * @return是否添加成功
     */
    public Boolean addMessage(Message message){
        message.setCreateTime(new Date());
        return messageDao.addMessage(message);
    }
}
