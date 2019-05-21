package com.young.mywork.common.uitls;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DateUtil {
    private static ThreadLocal<SimpleDateFormat> localDate = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        /**
         *多线程下 -- 错误的做法
         */
        //  badDateFormat();

        //ThreadLocal
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            Future<Date> dateFuture = executorService.submit(() -> {
                String text = "2019-05-16 15:07:40";
                localDate.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                return parse(text,localDate);
            });
            try {
                    System.out.println("date = " + dateFuture.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();

        //jdk 1.8 使用DateTimeFormatter LocalDateTime
        //  dateFormat();
    }

    private static void dateFormat() throws InterruptedException {
        final String text = "2019-05-16 10:43:45";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            Future<LocalDateTime> localDateTimeFuture = executorService.submit(() -> getParseDate(text, formatter));
            try {
                System.out.println("localDateTime = " + localDateTimeFuture.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    private static LocalDateTime getParseDate(String text, DateTimeFormatter formatter) {
        return LocalDateTime.parse(text, formatter);
    }


    private static void badDateFormat() throws InterruptedException {
        //SimpleDateFormat 是线程不安全的,在多线程下会引起异常
        final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String text = "2019-05-16 10:43:45";
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            executorService.execute(() -> {
                try {
                    DATE_FORMAT.parse(text);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });

        }
        Thread.sleep(3000000);
        executorService.shutdown();

    }


    public static Date parse(String str, ThreadLocal<SimpleDateFormat> localDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = DateUtil.localDate.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
            DateUtil.localDate.set(simpleDateFormat);
        }
        return simpleDateFormat.parse(str);
    }

    public static String format(Date date) throws Exception {
        SimpleDateFormat sdf = localDate.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
        }
        return sdf.format(date);
    }
}
