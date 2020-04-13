package com.young.mywork.common.gof.mysingle;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.mywork.common.gof.mysingle
 * @ClassName Singleton
 * @Description
 * @Author young
 * @Modify young
 * @Date 2020/4/12 11:39
 * @Version 1.0.0
 **/
public class Singleton {
    //懒汉式
    //私有字段 提供公有的方法
    private static Singleton singleton;
    //私有化构造方法,使其不能在其他类中实例化
    private Singleton (){}
    public static Singleton getInstance(){
        if (singleton==null)
            return new Singleton();
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
    }
}
