package com.young.mywork.common.gof.mysingle;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.mywork.common.gof.mysingle
 * @ClassName Singleton2
 * @Description
 * @Author young
 * @Modify young
 * @Date 2020/4/12 11:59
 * @Version 1.0.0
 **/
public class Singleton2 {


    //静态内部类实现单例,
    // 在静态内部类中的构造代码块中初始化单例
    private static class SingletonHolder{
        private static Singleton2 instance;
        private SingletonHolder(){}

        static {
            new Singleton2();
        }
        public  static Singleton2 getInstance(){
            return instance;
        }

    }

    //对外提供get方法
    public static Singleton2 getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        System.out.println("instance = " + instance);
    }
}
