package com.zjn.web;

import com.zjn.domain.Manager;
import com.zjn.factory.BasicFactory;
import com.zjn.service.ManagerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "FindManagerByCondServlet")
public class FindManagerByCondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取查询条件，封装到bean中

        try {
            request.setCharacterEncoding("utf-8");
            ManagerService service=BasicFactory.getFactory().getInstance(ManagerService.class);
            Manager manager=new Manager();
            BeanUtils.populate(manager,request.getParameterMap());
            //调用service中条件查询客户的方法，查出符合条件的客户

            List<Manager> list=service.findManagerByCond(manager);
            //将查到的客户存入request域中带到listManager.jsp页面展示
            request.setAttribute("list",list);
            request.getRequestDispatcher("/listManager.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }
}
