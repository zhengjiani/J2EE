package com.zjn.jdbc;

import com.zjn.dao.TeacherDAO;
import com.zjn.domain.Teacher;
import com.zjn.dao.TeacherDaoImpl;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        TeacherDAO dao=new TeacherDaoImpl();
        try{
            dao.add(new Teacher("小黑","是一个很好很好的人",19));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
