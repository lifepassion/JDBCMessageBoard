package com.jdbc.common;

import java.sql.*;

public final class ConnectionUtils {
    private ConnectionUtils(){}

    private static String url="jdbc:mysql:///message_board?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    private static String username="root";
    private static String psssword="123456";

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("无法找到驱动程序类");
        }
    }

    /**
     * 获得连接的方法
     * @return
     */
    public static Connection getConnection(){
        try {
           return  DriverManager.getConnection(url,username,psssword);
        } catch (SQLException throwables) {
            System.out.println("创建数据库链接失败");
        }
        return null;
    }

    /**
     * 释放资源的方法
     * @param connection
     * @param statement
     * @param resultSet
     */

    public static void  relese(Connection connection, Statement statement,ResultSet resultSet){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            connection=null;
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            statement=null;
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resultSet=null;
        }

    }

    /**
     * 释放资源的方法
     * @param connection
     * @param statement
     */
    public static void relese(Connection connection,Statement statement){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            connection=null;
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            statement=null;
        }
    }

}
