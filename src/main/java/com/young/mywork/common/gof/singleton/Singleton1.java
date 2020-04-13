package com.young.mywork.common.gof.singleton;

public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1(){ }
    //饿汉式
    public static Singleton1 getInstance() {
        return instance;
    }


}
