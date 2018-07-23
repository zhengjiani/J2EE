package com.zjn.web;

import com.zjn.domain.Manager;
import com.zjn.domain.Page;
import com.zjn.factory.BasicFactory;
import com.zjn.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageManagerServlet")
public class PageManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerService service=BasicFactory.getFactory().getInstance(ManagerService.class);
        //1.获取当前要显示的页和每页记录数
        int thispage=Integer.parseInt(request.getParameter("thispage"));
        int rowperpage=5;
        //2.调用service中分页查询客户的方法，查找出客户信息
       Page page=service.pageManager(thispage,rowperpage);
        //3.存入request域中，带到pageList.jsp页面中进行显示
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pageList.jsp").forward(request,response);
    }
}
