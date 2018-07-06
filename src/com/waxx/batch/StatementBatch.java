package com.waxx.batch;

import com.zjn.jdbc.DbUtils;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Statement方式执行批处理：
 * 优点：可以执行多条不同结构的sql语句
 * 缺点：没有使用预编译机制，效率低下
 * 如果要执行多条结构相同仅仅参数不同的sql时，仍然需要写多条语句的主干
 */
public class StatementBatch {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        try{
            conn=DbUtils.getConnection();
            stat=conn.createStatement();
            stat.addBatch("insert into batchDemo values(null,'aaaa');");
            stat.addBatch("insert into batchDemo values(null,'bbb');");
            stat.addBatch("insert into batchDemo values(null,'ccc');");
            stat.addBatch("insert into batchDemo values(null,'ddd');");
            stat.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(null,stat,conn);
        }
    }
}
