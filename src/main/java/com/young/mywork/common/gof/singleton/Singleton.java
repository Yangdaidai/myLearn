package com.young.mywork.common.gof.singleton;

/**
 * Author 10248
 * Date 2019/5/17 18:06
 * Description
 */
public class Singleton {
    //l懒汉
    // 安全的单例模式 无锁
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.instance;
        System.out.println("singleton = " + singleton);
    }
}


