package com.young.mywork.common.gof.mysingle;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.mywork.common.gof.mysingle
 * @ClassName SingletonTest
 * @Description
 * @Author young
 * @Modify young
 * @Date 2020/4/12 11:51
 * @Version 1.0.0
 **/
public class SingletonTest {
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println("singleton2 = " + singleton2);

        Singleton3 instance = Singleton3.getInstance();
        System.out.println("instance = " + instance);

    }
}
