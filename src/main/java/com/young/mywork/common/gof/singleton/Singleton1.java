package com.young.mywork.common.gof.singleton;

public class Singleton1 {
    private static Singleton1 ourInstance = new Singleton1();

    //饿汉式
    public static Singleton1 getInstance() {
        return ourInstance;
    }

}
