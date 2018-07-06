package com.waxx.lob;

import com.zjn.jdbc.DbUtils;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 大文本，大数据：把一本小说存进去
 *
 */
public class TextDemo1 {
    @Test
    public void addText(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn=DbUtils.getConnection();
            ps=conn.prepareStatement("insert into textdemo values (null,?,?) ");
            ps.setString(1,"mmm.txt");
            File file=new File("D:\\code\\Demo1\\src\\1.txt");
            ps.setCharacterStream(2,new FileReader(file),(int)file.length());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DbUtils.close(rs,ps,conn);
        }
    }
    @Test
    public void findText(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            conn=DbUtils.getConnection();
            ps=conn.prepareStatement("select * from textdemo where id=?");
            ps.setInt(1,1);
            rs=ps.executeQuery();
            while(rs.next()){
                String filename=rs.getString("name");
                Reader reader=rs.getCharacterStream("content");
                Writer writer=new FileWriter(filename);
                char [] cs=new char[1024];
                int i=0;
                while ((i=reader.read(cs))!=-1){
                    writer.write(cs,0,i);
                }
                reader.close();
                writer.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(rs,ps,conn);
        }
    }

}
