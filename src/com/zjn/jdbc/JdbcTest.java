package com.zjn.jdbc;

import com.zjn.model1.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javafx.scene.input.KeyCode.T;

public class JdbcTest {
    /**
     * 查询的方法
     */
    public static void findAll(){
        //通过工具类获取数据库连接
        Connection conn =DbUtils.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select id,name,description,age from teacher";
        try {
            ps =conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Teacher t=new Teacher();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setAge(rs.getInt(4));
                t.setDescription(rs.getString(3));
                System.out.println(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(rs,ps,conn);
        }
    }
    public static void main(String[] args) {
        findAll();
    }
}
