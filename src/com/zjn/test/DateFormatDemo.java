package com.zjn.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.*;
import static java.util.Locale.CHINA;

public class DateFormatDemo {
    /**
     * 将日期对象转换成字符串表示形式，此时根据地区语言环境
     * 不同，需要转成不同的字符串样式形式
     */
    @Test
    public void test1(){
        Date date =new Date();
        DateFormat format=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CHINA);
        String DateStr=format.format(date);
        System.out.println(DateStr);
    }
    /**
     * 将字符串形式的日期时间对象转换为时间
     */
    @Test
    public void test2() throws ParseException {
        String DateStr="2018年7月23日 星期一 上午08时40分59秒 CST";
        DateFormat format=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CHINA);
        Date date=format.parse(DateStr);
        System.out.println(date.toLocaleString());
    }
    /**
     * 任意时间转换为字符串
     */
    @Test
    public  void test3() throws ParseException {
        String DateStr="09月~~10日##2013年**12时%20分%10秒";
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM月~~dd日##yyyy年**HH时%mm分%ss秒");
        Date date=dateFormat.parse(DateStr);
        System.out.println(date.toLocaleString());
    }

}
