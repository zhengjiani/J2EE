package com.zjn.service;

import com.zjn.dao.ManagerDao;
import com.zjn.domain.Manager;
import com.zjn.domain.Page;
import com.zjn.factory.BasicFactory;
import com.zjn.util.DaoUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

public class ManagerServiceImpl implements ManagerService{

    ManagerDao dao=BasicFactory.getFactory().getInstance(ManagerDao.class);
    @Override
    public void addManager(Manager manager) {
        //1.检查用户名是否已经存在
        if(dao.findUserByName(manager.getName())!=null){
            throw new RuntimeException("用户名已经存在");
        }
        //2.调用dao中的方法增加用户
        dao.addManager(manager);
    }


    public List<Manager> getAllManager() {
        return dao.getAllManager();
    }

    @Override
    public Manager findManagerById(String id) {
        return dao.findUserById(id);
    }

    @Override
    public void updateManager(Manager manager) {
        dao.updateManager(manager);
    }

    @Override
    public void delManagerByID(String id) {
        dao.delManagerByID(id);
    }

    @Override
    public void batchDel(String[] ids) {
        Connection conn=DaoUtils.getConn();
        try{
            conn.setAutoCommit(false);
            for(String id:ids){
                dao.delManagerByIDWithTrans(conn,id);
            }
//            int i=1/0;
            DbUtils.commitAndCloseQuietly(conn);
        }catch (Exception e){
            //回滚事务
            DbUtils.rollbackAndCloseQuietly(conn);
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Manager> findManagerByCond(Manager manager) {
        return dao.findManagerByCond(manager);
    }

    @Override
    public Page pageManager(int thispage, int rowperpage) {
        Page page=new Page();
        //--当前页
        page.setThispage(thispage);
        //--每页记录数
        page.setRowperpage(rowperpage);
        //--共有多少行
        int countrow=dao.getCountRow();
        page.setCountrow(countrow);
        //--共有多少页
        int countpage=countrow/rowperpage+(countrow%rowperpage==0?0:1);
        page.setCountpage(countpage);
        //首页
        page.setFirstpage(1);
        //尾页
        page.setLastpage(countpage);
        //--上一页
        page.setPrepage(thispage==1?1:thispage-1);
        //--下一页
        page.setNextpage(thispage==countpage?countpage:thispage+1);
        List<Manager> list=dao.getManagerByPage((thispage-1)*rowperpage,rowperpage);
        page.setList(list);
        return page;
    }


}
