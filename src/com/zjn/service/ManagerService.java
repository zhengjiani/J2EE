package com.zjn.service;

import com.zjn.domain.Manager;
import com.zjn.domain.Page;

import java.util.List;

public interface ManagerService {
    /**
     * 添加客户
     * 封装了用户信息的bean
     */
    void addManager(Manager manager);


    List<Manager> getAllManager();

    /**
     * 根据id查找客户信息
     * @param id 客户id
     * @return 查找到的客户信息，如果找不到则返回null
     */
    Manager findManagerById(String id);

    void updateManager(Manager manager);

    /**
     * 根据id删除客户信息
     * @param id
     */
    void delManagerByID(String id);

    /**
     * 批量删除客户，其中会进行事务管理
     * @param ids 所有要删除的id组成的数组
     */
    void batchDel(String[] ids);

    /**
     * 根据条件查询客户信息
     * @param manager 封装了查询条件的bean,其中可以有用户名，性别，客户类型
     * @return 符合条件的客户组成的集合
     */
    List<Manager> findManagerByCond(Manager manager);

    /**
     * 分页查询
     * @param thispage 当前页码
     * @param rowperpage 每页记录数
     * @return 当前页所有信息
     */
    Page pageManager(int thispage, int rowperpage);
}
