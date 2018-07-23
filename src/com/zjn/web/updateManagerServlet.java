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

@WebServlet(name = "updateManagerServlet")
public class updateManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ManagerService service = BasicFactory.getFactory().getInstance(ManagerService.class);
        try{
            //1.封装数据校验数据
            Manager manager = new Manager();
            BeanUtils.populate(manager, request.getParameterMap());
            //--单独处理爱好
            String [] prefs = request.getParameterValues("preference");
            StringBuffer buffer = new StringBuffer();
            for(String pref : prefs){
                buffer.append(pref+",");
            }
            String pref = buffer.substring(0, buffer.length()-1);
            manager.setPreference(pref);
            //2.调用Service中修改客户信息的方法
            service.updateManager(manager);
            //3.重定向到客户列表页面
            request.getRequestDispatcher("/servlet/ListManagerServlet").forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
