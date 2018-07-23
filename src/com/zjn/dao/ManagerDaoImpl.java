package com.zjn.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zjn.domain.Manager;
import com.zjn.util.DaoUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {

    @Override
    public Manager findUserByName(String name) {
        String sql="select * from customer where name = ?";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return runner.query(sql,new BeanHandler<Manager>(Manager.class),name);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void addManager(Manager manager) {
        String sql="insert into customer values (null,?,?,?,?,?,?,?,?)";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            runner.update(sql,manager.getName(),manager.getGender(),manager.getBirthday(),manager.getCellphone(),manager.getEmail(),manager.getPreference(),manager.getType(),manager.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<Manager> getAllManager() {
        String sql="select * from customer";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return runner.query(sql,new BeanListHandler<Manager>(Manager.class));
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Manager findUserById(String id) {
        String sql="select * from customer where id=?";

        try {
            QueryRunner runner=new QueryRunner(DaoUtils.getSource());
            return runner.query(sql,new BeanHandler<Manager>(Manager.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void updateManager(Manager manager) {
        String sql = "update customer set name=? ,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
        try{
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            runner.update(sql,manager.getName(),manager.getGender(),manager.getBirthday(),manager.getCellphone(),manager.getEmail(),manager.getPreference(),manager.getType(),manager.getDescription(),manager.getId());
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delManagerByID(String id) {
        String sql = "delete from customer where id=?";
        try{
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            runner.update(sql,id);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delManagerByIDWithTrans(Connection conn, String id) throws SQLException {
        String sql = "delete from customer where id=?";
        QueryRunner runner = new QueryRunner();
        runner.update(conn,sql,id);

    }

    @Override
    public List<Manager> findManagerByCond(Manager manager) {
        String sql="select * from customer where 1=1";
        List<Object> list=new ArrayList<Object>();
        if(manager.getName()!=null && !"".equals(manager.getName())){
            sql += "name like ?";
            list.add("%"+manager.getName()+"%");
        }
        if(manager.getGender()!=null && !"".equals(manager.getGender())){
            sql += "and gender= ?";
            list.add(manager.getGender());
        }
        if(manager.getType()!=null && !"".equals(manager.getType())){
            sql += "and type= ?";
            list.add(manager.getType());
        }

        try {
            QueryRunner runner=new QueryRunner(DaoUtils.getSource());
            if(list.size()<=0){
                return runner.query(sql,new BeanListHandler<Manager>(Manager.class));
            }else{
                return runner.query(sql,new BeanListHandler<Manager>(Manager.class),list.toArray());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int getCountRow() {
        String sql="select count(*) from customer";
        try{
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return ((Long)runner.query(sql,new ScalarHandler())).intValue();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public List<Manager> getManagerByPage(int from, int count) {
        String sql="select * from customer limit ?,?";
        try{
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return runner.query(sql,new BeanListHandler<Manager>(Manager.class),from,count);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }


}
