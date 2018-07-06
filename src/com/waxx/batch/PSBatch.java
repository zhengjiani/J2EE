package com.waxx.batch;

import com.zjn.jdbc.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * preparedStatement方式实现的批处理：
 * 优点：有预编译机制，效率比较高，执行多条结构相同，参数不同的sql时，不需要重复写sql的主干
 * 缺点：只能执行主干相同参数不同的sql，没有办法在一个批中加入结构不同的sql
 */
public class PSBatch {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn=DbUtils.getConnection();
            ps=conn.prepareStatement("insert into psbatch values(null,?)");
            for(int i=1;i<=10000;i++){
                ps.setString(1,"name");
                ps.addBatch();
                if(i%1000==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
           ps.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(null,ps,conn);
        }
    }
}
