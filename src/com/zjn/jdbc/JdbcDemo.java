package com.zjn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的增删改操作
 */
public class JdbcDemo {
    //数据库链接地址
    public final static String URL="jdbc:mysql://localhost:3306/demo1?useUnicode=true&amp;characterEncoding=utf-8";
    //用户名
    public final static String USERNAME ="root";
    //密码
    public final static String PASSWORD = "7410";
    //驱动
    public final static String  DRIVER= "com.mysql.jdbc.Driver";
    /**
     * 删除操作
     */
    public static void delete(){
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="delete from teacher  where id=2";
            Statement state=conn.createStatement();
            state.executeUpdate(sql);
            state.close();
            conn.close();
            System.out.println("delete successful");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 更新操作
     */
    public static void update(){
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="update teacher set age=19 where id=2";
            Statement state=conn.createStatement();
            state.executeUpdate(sql);
            state.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 插入操作
     */
    public static void insert(){
        //1.加载数据库驱动程序
        try {
            Class.forName(DRIVER);
            //2.获取数据库连接
            Connection conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //3.构造SQL语句
            String sql="insert into teacher(name,description,age)values('小白','一个人',18)";
            //4.构造一个statement实例（用来发送SQL语句的载体）
            Statement state=conn.createStatement();
            //5.执行SQL语句(相当于发送)
            state.executeUpdate(sql);
            //关闭连接（释放资源）
            state.close();
            conn.close();
            System.out.println("successful");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insert2(){
        String name="小白";
        int age=18;
        String description="一个人";
        try {
            Class.forName(DRIVER);
            Connection conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="insert into teacher(name,description,age)values('"+name+"','"+description+"',"+age+")";
            Statement state=conn.createStatement();
            state.executeUpdate(sql);
            state.close();
            conn.close();
            System.out.println("successful");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        //insert();
        //update();
        //delete();
        insert2();
    }
}
