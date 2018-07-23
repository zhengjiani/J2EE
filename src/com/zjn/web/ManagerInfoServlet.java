package com.zjn.web;

import com.zjn.domain.Manager;
import com.zjn.factory.BasicFactory;
import com.zjn.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerInfoServlet")
public class ManagerInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerService service=BasicFactory.getFactory().getInstance(ManagerService.class);
        //1.获取要查询的客户id
        String id=request.getParameter("id");
        //2.调用servlet中根据id查找客户的方法
        Manager manager=service.findManagerById(id);
        if(manager == null){
            throw new RuntimeException("找不到这个客户");
        }
        //3.将查找到的客户信息存入request域中，请求转发到updataManager.jsp页面展示
        request.setAttribute("Manager",manager);
        request.getRequestDispatcher("/updateManager.jsp").forward(request,response);


    }
}
