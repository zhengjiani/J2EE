package com.zjn.jdbcQuery;

import java.sql.*;

public class JdbcQueryDemo {
    //数据库链接地址
    public final static String URL="jdbc:mysql://localhost:3306/demo1?useUnicode=true&amp;characterEncoding=utf-8";
    //用户名
    public final static String USERNAME ="root";
    //密码
    public final static String PASSWORD = "7410";
    //驱动
    public final static String  DRIVER= "com.mysql.jdbc.Driver";

    /**
     * 查询操作
     */
    public static void query(){
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="select id,name,description,age from teacher";
            Statement state=conn.createStatement();
            state.executeQuery(sql);
            //执行查询并返回结果集
            ResultSet rs=state.executeQuery(sql);
            while (rs.next()){
                //rs.getInt("id");
               int id= rs.getInt(1);//列的顺序
                String name=rs.getString(2);
                String description=rs.getString(3);
                int age=rs.getInt(4);
                System.out.println("id="+id+",name="+name+",description"+description+",age="+age);
            }
            rs.close();
            state.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        query();
        System.out.println("success");
    }
}
