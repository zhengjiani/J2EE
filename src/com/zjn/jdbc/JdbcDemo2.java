package com.zjn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务处理
 */
public class JdbcDemo2 {
    //数据库链接地址
    public final static String URL="jdbc:mysql://localhost:3306/demo1?useUnicode=true&amp;characterEncoding=utf-8";
    //用户名
    public final static String USERNAME ="root";
    //密码
    public final static String PASSWORD = "7410";
    //驱动
    public final static String  DRIVER= "com.mysql.jdbc.Driver";
    public static void txTest(){
        Connection conn=null;
        try {
            Class.forName(DRIVER);
            conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            conn.setAutoCommit(false);//这是设置手动提交事务
            String sql1="insert into user(name,pwd)values(?,?)";
            String sql2="update user set pwd=? where name=?";
            PreparedStatement ps=conn.prepareStatement(sql1);
            ps.setString(1,"ry");
            ps.setString(2,"123");

            ps.executeUpdate();
            ps=conn.prepareStatement(sql2);
            ps.setString(1,"54321");
            ps.setString(2,"vince");
            ps.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();//事务回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        txTest();
    }
}
