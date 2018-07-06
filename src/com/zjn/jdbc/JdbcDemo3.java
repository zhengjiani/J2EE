package com.zjn.jdbc;

import com.waxx.pool.MyPool;

import java.sql.*;

public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        MyPool pool=new MyPool();
        try{
                conn=DbUtils.getConnection();
                ps=conn.prepareStatement("select * from demo1");
                rs=ps.executeQuery();
                while (rs.next()){
                    String name=rs.getString("name");
                    System.out.println(name);
                }
        }catch(Exception e){
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
