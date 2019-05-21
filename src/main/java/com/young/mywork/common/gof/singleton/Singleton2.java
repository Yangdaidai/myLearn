package com.young.mywork.common.gof.singleton;

import java.util.Objects;

public class Singleton2 {
    //加锁版
    private static Object object = new Object();
    private static Singleton2 singleton2;

    public static Singleton2 getInstance() {
        if (Objects.isNull(singleton2)) {
            synchronized (object) {
                if (Objects.isNull(singleton2)) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;

    }


}
