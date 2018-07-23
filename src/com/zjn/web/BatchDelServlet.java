package com.zjn.web;

import com.zjn.factory.BasicFactory;
import com.zjn.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BatchDelServlet")
public class BatchDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerService service=BasicFactory.getFactory().getInstance(ManagerService.class);
        //1.获取所有要删除的客户id
        String [] ids=request.getParameterValues("delId");
        //2.调用service层中批量删除客户的方法
        service.batchDel(ids);
        //3.重定向到客户列表页面
        request.getRequestDispatcher("/servlet/ListManagerServlet").forward(request,response);
    }
}
