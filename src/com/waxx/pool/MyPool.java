package com.waxx.pool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;



public class MyPool implements DataSource {

    private List<Connection> pool=new LinkedList<Connection>();
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for(int i=0;i<5;i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql:///demo1", "root", "7410");
                //pool.add(conn);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    @Override
    public Connection getConnection() throws SQLException {
        if(pool.size()==0){
            for(int i=0;i<5;i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql:///demo1", "root", "7410");
                pool.add(conn);
            }
        }
        Connection conn=pool.remove(0);
        //--利用动态代理改造close方法
        Connection proxy=(Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (clone().equals(method.getName())) {
                    //对于想要改造的close方法,我们自己写
                    recConn(conn);
                    return null;
                } else {
                    //对于不想改造的方法调用被代理者身上相同的方法
                    method.invoke(conn, args);
                }
                return proxy;
            }
        });
        System.out.println("获取了一个连接，池里还剩余"+pool.size()+"个连接");
        return proxy;
    }
    public void recConn(Connection conn){
        try {
            if(conn!=null&&!conn.isClosed()){
                pool.add(conn);
                System.out.println("还回了一个连接，池里还剩余"+pool.size()+"个连接");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
