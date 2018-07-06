package com.zjn.dao;

import com.zjn.domain.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    //添加方法
    public void add(Teacher t)throws SQLException;
    //更新方法
    public void update(Teacher t)throws SQLException;
    //删除方法
    public void delete(int id)throws SQLException;
    //查找方法
    public Teacher findById(int id) throws Exception;
    //查找所有
    public List<Teacher> findAll() throws Exception;

}
