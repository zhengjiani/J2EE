package com.zjn.jdbc;

import com.zjn.model1.Teacher;

import java.sql.*;

public class JdbcDemo1 {
    //数据库链接地址
    public final static String URL="jdbc:mysql://localhost:3306/demo1?useUnicode=true&amp;characterEncoding=utf-8";
    //用户名
    public final static String USERNAME ="root";
    //密码
    public final static String PASSWORD = "7410";
    //驱动
    public final static String  DRIVER= "com.mysql.jdbc.Driver";
    //登录
    //如果使用statement,会造成sql注入的安全性问题
    public static void login(String name,String pwd){
        Teacher t=null;
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //String sql="select id,name,pwd from user where name= and pwd=";
            StringBuffer sql=new StringBuffer("select id,name,pwd from user where name=''");
            sql.append(name).append("' and pwd='").append(pwd).append("'");
            Statement ps=conn.createStatement();//statement的子接口


            ResultSet rs=ps.executeQuery(sql.toString());
            if(rs.next()){

            }

            rs.close();
            ps.close();
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 使用PreparedStatement查询数据
     * @param id
     * @return
     */
    public static Teacher findById(int id){
        Teacher t=null;//声明对象
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="select name,description,age from teacher where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);//statement的子接口
            //设置占位符对应的值
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                t=new Teacher();
                t.setId(id);
                t.setName(rs.getString(1));
                t.setAge(rs.getInt(3));
                t.setDescription(rs.getString(2));
                //sql.date转为util.date
                //java.util.Date date=rs.getDate(4);
                //ps.setDate(4,new java.sql.Date(date.getTime()));
            }

            rs.close();
            ps.close();
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    /**
     * 使用
     * PreparedStatement删除数据
     */
    public static void delete(int id){
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="delete from teacher where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);//statement的子接口
            //设置占位符对应的值
            ps.setInt(1,id);


            ps.executeUpdate();
            ps.close();
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 使用
     * PreparedStatement修改更新数据
     */
    public static void update(Teacher t){
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="update teacher set name=?,description=?,age=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);//statement的子接口
            //设置占位符对应的值
            ps.setString(1,t.getName());
            ps.setInt(3,t.getAge());
            ps.setString(2,t.getDescription());
            ps.setInt(4,t.getId());


            ps.executeUpdate();
            ps.close();
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 使用
     * PreparedStatement插入数据
     */
    public static void insert(Teacher t){
        try {
            Class.forName(DRIVER);
            Connection conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql="insert into teacher(name,description,age)values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);//statement的子接口
            //设置占位符对应的值
            ps.setString(1,t.getName());
            ps.setInt(3,t.getAge());
            ps.setString(2,t.getDescription());

            ps.executeUpdate();
            ps.close();
            conn.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        //insert(t);
        //update(t);
        //delete(4);
         Teacher m=findById(5);
         System.out.println(m);

    }
}
