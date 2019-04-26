package com.young.mywork.common.reflection;


import java.lang.reflect.Method;
import java.util.Arrays;

public class reflection {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.asList(methods).stream().forEach(method -> System.out.println("method name is :  " + method.getName()));
    }

}
