package com.zjn.dao;

import com.zjn.domain.Manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ManagerDao {
    /**
     *根据用户名查找用户
     * @param name
     * @return 找到的用户，如果找不到返回null
     */
    Manager findUserByName(String name);

    /**
     * 添加客户
     * @param manager
     */
    void addManager(Manager manager);
    /**
     * 查询所有客户信息组成的集合
     * @return 封装了所有客户信息的集合，如果没有任何客户，返回的集合中内容为空
     */
    List<Manager> getAllManager();

    /**
     * 根据id查找客户
     * @param id 客户id
     * @return 客户bean
     */
    Manager findUserById(String id);

    void updateManager(Manager manager);

    /**
     * 根据id删除客户
     * @param id
     */
    void delManagerByID(String id);

    /**
     * 根据id删除事务并管理客户
     * @param id
     */
    void delManagerByIDWithTrans(Connection conn,String id) throws SQLException;

    /**
     * 根据条件查询客户信息
     * @param manager 封装了查询条件的bean,其中可以有用户名，性别，客户类型
     * @return 符合条件的客户组成的集合
     */
    List<Manager> findManagerByCond(Manager manager);

    /**
     * 查询数据库中一共有多少条记录
     * @return
     */
    int getCountRow();

    /**
     * 查询指定记录后多少条记录
     * @param from 从哪条记录后
     * @param count 取多少条
     * @return
     */
    List<Manager> getManagerByPage(int from, int count);
}
