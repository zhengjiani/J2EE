package com.zjn.jdbc;

import com.zjn.base.HandlerResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplete {
    /**
     * 实现增删改的抽象。可变参数
     * @param sql
     * @param args
     */
    public int update(String sql,Object...args){
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn=DbUtils.getConnection();
            ps=conn.prepareStatement(sql);
            //设置占位符的参数
            if(args!=null){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            DbUtils.close(null,ps,conn);
        }

    }

    /**
     * 查询方法的抽象
     * @param sql
     * @param handler
     * @param args
     * @return
     */
    public Object query(String sql, HandlerResultSet handler,Object...args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();
            return handler.doHandler(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
