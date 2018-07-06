package com.zjn.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.waxx.pool.MyPool;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0Demo {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
        ComboPooledDataSource source=new ComboPooledDataSource();
        //方式一
//        try {
//            source.setDriverClass("com.mysql.jdbc.Driver");
//            source.setJdbcUrl("jdbc:mysql:///day111");
//            source.setUser("root");
//            source.setPassword("root");
//            conn=DbUtils.getConnection();
//            ps=conn.prepareStatement("select * from demo1");
//            rs=ps.executeQuery();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        conn = source.getConnection();
        ps = conn.prepareStatement("select * from account");
        rs = ps.executeQuery();
        while(rs.next()){
            String name = rs.getString("name");
            System.out.println(name);
        }
    }catch (Exception e) {
        e.printStackTrace();
    }finally{
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs = null;
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                ps = null;
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn = null;
            }
        }
    }
}
}
