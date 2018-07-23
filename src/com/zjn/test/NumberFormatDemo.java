package com.zjn.test;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {
    /**
     * 将数字表示成字符串形式
     */
    @Test
    public void test1(){
        double money=100000.00;
        NumberFormat format=NumberFormat.getCurrencyInstance(Locale.CHINA);
        String NStr=format.format(money);
        System.out.println(NStr);
    }
}
