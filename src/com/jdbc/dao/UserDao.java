package com.jdbc.dao;

import com.jdbc.bean.User;
import com.jdbc.common.ConnectionUtils;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * UserDao
 * @author passionlife
 */
public class UserDao {

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户bean，失败返回null
     */

    public User login(String username,String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            //1.获得连接
            connection = ConnectionUtils.getConnection();
            //2.编写SQL
            String sql = "SELECT * FROM user WHERE username=? AND password=? ";
            //3.获得preparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            //4.执行SQL，返回
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setReal_name(resultSet.getString("real_name"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
            }

        } catch (SQLException throwables) {
            System.out.println("登陆失败");
        } finally {
            ConnectionUtils.relese(connection, preparedStatement, resultSet);

            return user;
        }
    }


    /**
     * 修改用户的方法
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        //1.获得连接
        connection=ConnectionUtils.getConnection();
        //2.编写Sql
        String sql="UPDATE user SET username=?,password=?,real_name=?,birthday=?,phone=?,address=? WHERE id=?";
        try {
            //3.获取preareStatement对象
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getReal_name());
            preparedStatement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.setString(5,user.getPhone());
            preparedStatement.setString(6,user.getAddress());
            preparedStatement.setLong(7,user.getId());

            //4.执行prepare对象，返回
            if(preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionUtils.relese(connection,preparedStatement);
        }
        return false;
    }
}
