package com.waxx.dao;

import com.waxx.domain.User;

public interface UserDAO {
    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return根据用户名找到的用户信息bean，如果没找到则返回NULL
     */
    public User findUserByUserName(String username);

    /**
     * 添加用户
     * @param user 要添加的用户信息Bean
     */
    public void addUser(User user);

    /**
     * 根据用户名、密码查找对应的用户
     * @param username 用户名
     * @param password 密码
     * @return 找到的用户，如果找不到则返回null
     */
    public User finduserByUNandPSW(String username,String password);

}
