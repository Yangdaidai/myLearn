package com.young.mywork.common.uitls;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class DateUtil {

    private DateUtil() {
    }

    //SimpleDateFormat 是线程不安全的,在多线程下会引起异常
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 500; i++) {
            executorService.execute(() -> IntStream.range(0, 1000000).forEach(i1 -> {
                try {
                    DATE_FORMAT.parse("2014-01-01 00:00:00");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }));
        }
        Thread.sleep(3000000);
    }

}
