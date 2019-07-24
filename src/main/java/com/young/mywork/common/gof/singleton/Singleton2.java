package com.young.mywork.common.gof.singleton;

import java.util.Objects;

public class Singleton2 {
    //加锁版
    private static Singleton2 singleton2;

    public static Singleton2 getInstance() {
        if (Objects.isNull(singleton2)) {
            synchronized (Singleton2.class) {
                if (Objects.isNull(singleton2)) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;

    }

    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2);
    }
}
