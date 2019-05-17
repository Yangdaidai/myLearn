package com.young.mywork.common.reflection;

import java.lang.reflect.Method;

public class InvokeTester {
    public int add(int a, int b){
        return a+b;
    }

    public String echo(String message){
        return "echo "+message;
    }

    public static void main(String[] args) throws Exception {
        InvokeTester invokeTester = new InvokeTester();
        int sum = invokeTester.add(2, 5);
        System.out.println("sum = " + sum);
        System.out.println(invokeTester.echo("Tom"));
        System.out.println("---------------------------");

        //通过反射方式
        Class<InvokeTester> invokeTesterClass = InvokeTester.class;
        InvokeTester invokeTester1 = invokeTesterClass.newInstance();
        Method add = invokeTesterClass.getMethod("add", new Class[]{int.class, int.class});
        Object result = add.invoke(invokeTester1, new Object[]{1, 2});
        System.out.println("invoke add result = " + result);

    }


}
