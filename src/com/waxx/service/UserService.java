package com.waxx.service;

import com.waxx.dao.UserDAO;
import com.waxx.domain.User;
import com.waxx.exception.MsgException;
import com.waxx.factory.DaoFactory;

public class UserService {
    private UserDAO dao=DaoFactory.getFactory().getDao();

    /**
     * 添加用户
     * @param user
     * @throws MsgException
     */
    public void registUser(User user)throws MsgException {
        //检查用户名是否已经存在，如果存在则提示
        if(dao.findUserByUserName(user.getUsername())!=null){
                throw new MsgException("用户名已经存在");
        }
        //如果不存在则调用dao中的方法添加用户
        dao.addUser(user);
    }

        /**
         * 检查用户名密码是否正确
         */
       public User isUser(String username,String password){
           return dao.finduserByUNandPSW(username,password);
       }


}
