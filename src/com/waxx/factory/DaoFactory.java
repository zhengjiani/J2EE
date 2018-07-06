package com.waxx.factory;

import com.waxx.dao.UserDAO;

import java.io.FileReader;
import java.util.Properties;

public class DaoFactory {
    private static DaoFactory factory=new DaoFactory();
    private static Properties prop=null;
    static{
        try{
            prop=new Properties();
            prop.load(new FileReader(DaoFactory.class.getClassLoader().getResource("com/util/db/db-config.properties").getPath()));
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private DaoFactory(){}

    public static  DaoFactory getFactory(){
        return factory;
    }
    public UserDAO getDao() {
        try {
            String clazz = prop.getProperty("UserDao");
            return (UserDAO) Class.forName(clazz).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
