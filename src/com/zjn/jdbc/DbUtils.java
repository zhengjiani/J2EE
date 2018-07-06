package com.zjn.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 数据库操作工具类
 */
public class DbUtils {
    //数据库链接地址
    public  static String URL;
    //用户名
    public  static String USERNAME;
    //密码
    public  static String PASSWORD ;
    //驱动
    public  static String  DRIVER;

    //加载配置文件
    private static ResourceBundle rb=ResourceBundle.getBundle("com.zjn.jdbc.db-config");
    private DbUtils(){}//不希望实例化，提供私有方法单例
    //使用静态块加载驱动程序
    static {
        URL=rb.getString("jdbc.url");
        USERNAME=rb.getString("jdbc.username");
        PASSWORD=rb.getString("jdbc.password");
        DRIVER=rb.getString("jdbc.driver");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义一个获取数据库连接的方法
    public static Connection getConnection() {
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库获取连接失败");
        }
        return conn;
    }
    //关闭数据库连接
    public static void close(ResultSet rs, Statement stat,Connection conn){

            try {
                if(rs!=null) rs.close();
                if(stat!=null) stat.close();
                if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }
}
