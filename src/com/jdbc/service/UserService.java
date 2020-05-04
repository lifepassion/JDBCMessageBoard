package com.jdbc.service;

import com.jdbc.bean.User;
import com.jdbc.dao.UserDao;

/**
 * @author passionlife
 */
public class UserService {

    private UserDao userDao;
    public UserService(){
        userDao=new UserDao();
    }


    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户bean，失败返回null
     */
    public User login(String username, String password) {

        return userDao.login(username,password);
    }

    /**
     * 修改用户
     * @param user
     * @return是否修改成功
     */
    public boolean updateUser(User user){

        return userDao.updateUser(user);
    }

}
