package com.zjn.test;

import com.zjn.util.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class AddDataTest {
    @Test
    public void add() throws SQLException {
        String sql="insert into customer values (null,?,?,?,?,?,?,?,?)";
        QueryRunner runner=new QueryRunner(DaoUtils.getSource());
        for(int i=1;i<=100;i++){
            runner.update(sql,"name"+i,"男","1999-09-09","10000","aaa@qq.com","篮球","青铜客户","desc"+i);
        }

    }
}
