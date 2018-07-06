package com.waxx.impl;

import com.waxx.dao.UserDAO;
import com.waxx.domain.User;
import com.mysql.jdbc.Connection;
import com.zjn.jdbc.DbUtils;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl implements UserDAO {

    public void addUser(User user) {
        String sql = "insert into users values (null,'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getTyname()+"')";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            conn = (Connection) DbUtils.getConnection();
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            DbUtils.close(rs, stat, conn);
        }
    }

    @Override
    public User finduserByUNandPSW(String username, String password) {
        String sql = "select * from users where username='"+username+"' and password='"+password+"'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            conn = (Connection) DbUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTyname(rs.getString("tyname"));
//                user.setNickname(rs.getString("nickname"));
//                user.setEmail(rs.getString("email"));
                return user;
            }else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            DbUtils.close(rs, stat, conn);
        }
    }

    public User findUserByUserName(String username) {
        String sql = "select * from users where username='"+username+"'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            conn = (Connection) DbUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTyname(rs.getString("tyname"));
//                user.setNickname(rs.getString("nickname"));
//                user.setEmail(rs.getString("email"));
                return user;
            }else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            DbUtils.close(rs, stat, conn);
        }
    }
}
