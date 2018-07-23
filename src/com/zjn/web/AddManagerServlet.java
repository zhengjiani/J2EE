package com.zjn.web;

import com.zjn.domain.Manager;
import com.zjn.factory.BasicFactory;
import com.zjn.service.ManagerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AddManagerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ManagerService service =BasicFactory.getFactory().getInstance(ManagerService.class);

        try {
            //1.封装数据，校验数据
            Manager manager=new Manager();
            BeanUtils.populate(manager,request.getParameterMap());
            //单独处理爱好
            String [] prefs=request.getParameterValues("preference");
            StringBuffer buffer=new StringBuffer();
            for(String pref:prefs){
                buffer.append(pref+",");
            }
            String pref=buffer.substring(0,buffer.length()-1);
            manager.setPreference(pref);
            //2.调用service中的方法添加客户
            service.addManager(manager);
            //3.重定向回到主页
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
