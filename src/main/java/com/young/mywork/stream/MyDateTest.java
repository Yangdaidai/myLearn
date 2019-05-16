package com.young.mywork.stream;


import java.text.SimpleDateFormat;
import java.util.*;

public class MyDateTest {
    public static void main(String[] args) {

        Date dNow = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dNow);

        int month = calendar.get(Calendar.MONTH);
        System.out.println("month = " + month);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("day = " + day);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("hour = " + hour);

        int year = calendar.get(Calendar.YEAR);
        System.out.println("year = " + year);

        Date dBefore = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式 yyyy-MM-dd HH:mm:ss
        String defaultStartDate = sdf.format(dBefore);

        System.out.println("defaultStartDate = " + defaultStartDate);


    }



}
