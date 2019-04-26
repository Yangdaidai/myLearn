package com.young.mywork.common.collection;


import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {

        Random random = new Random();
        int anInt = random.nextInt();
        int anInt1 = random.nextInt(1000);
        System.out.println("anInt = " + anInt);
        System.out.println("anInt1 = " + anInt1);
    }
}
