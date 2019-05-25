package com.young.mywork.stream.functions;

import java.util.function.Function;

/**
 * Author 10248
 * Date 2019/5/25 11:03
 * Description
 */
public class MyFunction {

    //Function 接口接受一个参数并生成结果。默认方法可用于将多个函数链接在一起（compose, andThen）
    public static void main(String[] args) {
        Function<String,Integer> toInteger=Integer::valueOf;
        Function<String,String> backToString=toInteger.andThen(String::valueOf);
        String intern = backToString.apply("1234").intern();
        System.out.println(intern);
    }
}
