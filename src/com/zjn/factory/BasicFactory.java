package com.zjn.factory;



import com.zjn.dao.ManagerDao;
import com.zjn.service.ManagerService;
import com.zjn.service.ManagerServiceImpl;

import java.io.FileReader;
import java.util.Properties;

public class BasicFactory {
    private static BasicFactory factory = new BasicFactory();
    private static Properties prop = null;

    private BasicFactory() {

    }

    public static BasicFactory getFactory() {
        return factory;
    }

    static {

        try {
            prop = new Properties();
            prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config").getPath()));
//            FileReader reader=new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath());
//            prop.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//    public ManagerDao getDao(){
//        String clazz=prop.getProperty("ManagerDao");
//        try {
//            return (ManagerDao) Class.forName(clazz).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//}

    public <T> T getInstance(Class<T> clazz){

        try {
            String cName=clazz.getSimpleName();
            String cImplName=prop.getProperty(cName);
            return (T)Class.forName(cImplName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
