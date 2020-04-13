package com.young.mywork.common.gof.mysingle;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.mywork.common.gof.mysingle
 * @ClassName Singleton1
 * @Description
 * @Author young
 * @Modify young
 * @Date 2020/4/12 11:55
 * @Version 1.0.0
 **/
public class Singleton1 {
    //饿汉式
    private static Singleton1  instance=new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        System.out.println("instance = " + instance);
    }
}
