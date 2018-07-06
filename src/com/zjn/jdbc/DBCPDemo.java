package com.zjn.jdbc;

import com.waxx.pool.MyPool;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPDemo {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
         MyPool pool=new MyPool();

//        BasicDataSource source=new BasicDataSource();
//        source.setDriverClassName("com.mysql.jdbc.Driver");
//        source.setUrl("jdbc:mysql:///day11");
//        source.setUsername("root");
//        source.setPassword("root");

        try {
            Properties prop=new Properties();
            prop.load(new FileReader("dbcp.properties"));
            BasicDataSourceFactory factory=new BasicDataSourceFactory();
            DataSource source=factory.createDataSource(prop);
            conn=DbUtils.getConnection();
            ps=conn.prepareStatement("select * from demo1");
            rs=ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            DbUtils.close(rs,ps,conn);
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    rs=null;
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    ps=null;
                }
            }
            if(conn!=null){
                pool.recConn(conn);
            }
        }
    }
}
