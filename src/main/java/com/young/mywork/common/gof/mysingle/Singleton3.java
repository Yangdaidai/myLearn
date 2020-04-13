package com.young.mywork.common.gof.mysingle;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.mywork.common.gof.mysingle
 * @ClassName Singleton3
 * @Description
 * @Author young
 * @Modify young
 * @Date 2020/4/12 12:11
 * @Version 1.0.0
 **/
public class Singleton3 {

    private static class SingletonHolder{
        private static final Singleton3 INSTANCE =new Singleton3();
        private SingletonHolder(){}
        public static Singleton3 getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }


    public  static Singleton3 getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton3 instance = SingletonHolder.getInstance();
        System.out.println("instance = " + instance);
    }
}
