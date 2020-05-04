package com.jdbc.dao;

import com.jdbc.bean.Message;
import com.jdbc.common.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageDao
 *
 * @author passionlife
 */
public class MessageDao {


    /**
     * 分页查询留言信息
     *
     * @param page
     * @param pageSize
     * @return每一页留言
     */
    public List<Message> getMessages(int page, int pageSize) {
        List<Message> messages = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //获得数据库连接
        connection = ConnectionUtils.getConnection();
        //编写Sql语句,执行Sql语句
        String sql = "SELECT * FROM message ORDER BY create_time DESC LIMIT ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (page - 1) * pageSize);
            preparedStatement.setInt(2, pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                messages.add(new Message(resultSet.getLong("id"),
                        resultSet.getLong("user_Id"),
                        resultSet.getString("username"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getTimestamp("create_time")
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionUtils.relese(connection, preparedStatement, resultSet);
        }
        return messages;
    }

    /**
     * 计算所有留言的个数
     *
     * @return所有留言个数
     */

    public int getMessagesCount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        connection = ConnectionUtils.getConnection();
        String sql = "SELECT COUNT(*) AS total FROM message";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("total");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionUtils.relese(connection, preparedStatement, resultSet);
        }
        return 0;
    }

    /**
     * 添加message
     *
     * @param message
     * @return是否添加成功
     */
    public boolean addMessage(Message message) {
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();

        String sql = "INSERT INTO message VALUES (null,?,?,?,?,?)";

        try {
            statement = connection.prepareStatement(sql);

            statement.setLong(1, message.getUserId());
            statement.setString(2, message.getUsername());
            statement.setString(3, message.getTitle());
            statement.setString(4, message.getContent());
            statement.setTimestamp(5, new Timestamp(message.getCreateTime().getTime()));

            if (statement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionUtils.relese(connection, statement);
        }
        return false;
    }
}
