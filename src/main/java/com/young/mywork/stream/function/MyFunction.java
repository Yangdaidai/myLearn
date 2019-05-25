package com.young.mywork.stream.function;

import java.util.function.Function;

/**
 * Author 10248
 * Date 2019/5/25 11:03
 * Description
 */
public class MyFunction {

    public static void main(String[] args) {
        Function<String,Integer> toInteger=Integer::valueOf;
        Function<String,String> backToString=toInteger.andThen(String::valueOf);
        String intern = backToString.apply("1234").intern();
        System.out.println(intern);
    }
}
