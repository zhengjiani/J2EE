package com.zjn.dao;

import com.zjn.base.HandlerResultSet;
import com.zjn.dao.TeacherDAO;
import com.zjn.domain.Teacher;
import com.zjn.jdbc.JdbcTemplete;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TeacherDao的具体实现类
 */
public class TeacherDaoImpl implements TeacherDAO {
    private JdbcTemplete jdbcTemplete;

    public TeacherDaoImpl() {
        jdbcTemplete = new JdbcTemplete();
    }

    /**
     * 实现添加方法
     *
     * @param t
     * @throws SQLException
     */
    @Override
    public void add(Teacher t) throws SQLException {
        String sql = "insert into teacher(name,description,age)values(?,?,?)";
        jdbcTemplete.update(sql, t.getName(), t.getDescription(), t.getAge());
    }

    /**
     * 删除方法
     *
     * @param t
     * @throws SQLException
     */
    @Override
    public void update(Teacher t) throws SQLException {
        String sql = "update teacher set name=?,description=?,age=? where id=?";
        jdbcTemplete.update(sql, t.getName(), t.getDescription(), t.getAge(), t.getId());

    }

    /**
     * 删除方法
     *
     * @param id
     * @throws SQLException
     */
    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from teacher where id=?";
        jdbcTemplete.update(sql, id);
    }

    @Override
    public Teacher findById(final int id) throws Exception {

        String sql = "select name,description,age from teacher where id=?";
        return (Teacher) jdbcTemplete.query(sql, new HandlerResultSet() {
            @Override
            public Object doHandler(ResultSet rs) throws SQLException {
                Teacher t = null;

                if (rs.next()) {
                    t = new Teacher();
                    t.setId(id);
                    t.setName(rs.getString(1));
                    t.setDescription(rs.getString(2));
                    t.setAge(rs.getInt(3));

                }

                return t;
            }
        }, id);


    }


    @Override
    public List<Teacher> findAll() throws Exception {

        String sql = "select name,description,age from teacher";
        return (List<Teacher>) jdbcTemplete.query(sql, new HandlerResultSet() {
            @Override
            public Object doHandler(ResultSet rs) throws SQLException {
                List<Teacher> teachers = new ArrayList<Teacher>();
                Teacher t = null;
                while (rs.next()) {
                    t = new Teacher();
                    t.setId(rs.getInt(1));
                    t.setName(rs.getString(2));
                    t.setDescription(rs.getString(3));
                    t.setAge(rs.getInt(4));
                    teachers.add(t);

                }
                return teachers;
            }
        });
    }
    }









