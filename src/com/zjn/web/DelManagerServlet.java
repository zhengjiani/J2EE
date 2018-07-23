package com.zjn.web;

import com.zjn.factory.BasicFactory;
import com.zjn.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelManagerServlet")
public class DelManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerService service=BasicFactory.getFactory().getInstance(ManagerService.class);
        //1.获取要删除的客户id
        String id=request.getParameter("id");
        //2.调用service中根据id删除客户的方法
        service.delManagerByID(id);
        //3.请求转发到客户列表页面
        request.getRequestDispatcher("/servlet/ListManagerServlet").forward(request,response);
    }
}
