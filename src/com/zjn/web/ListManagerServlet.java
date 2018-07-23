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
import java.util.List;

@WebServlet(name = "ListManagerServlet")
public class ListManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerService service=BasicFactory.getFactory().getInstance(ManagerService.class);
        //1.调用Service中查询所有客户的方法，查找到所有客户
        List<Manager> list=service.getAllManager();
        //2.将查找到的信息存入request域，请求转发到listManager.jsp页面进行
        request.setAttribute("list",list);
        request.getRequestDispatcher("/listManager.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
