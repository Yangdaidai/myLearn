package com.young.mywork.common.string;


/**
 * Author 10248
 * Date 2019/5/13 10:07
 * Description
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = new String("xyz");
        System.out.println("str = " + str);
        str.intern();
        //        上面的代码创建了两个对象，一个存放在堆中，一个存放在字符串常量池中。
        //        当然，需要我们注意的是，如果之前常量池中已经存在"xyz"这个字符串，那么，上面的语句就只会在堆中创建一个对象了。

        String str1 = "xyz";
        //        这样，就只会创建一个存放在字符串常量池中的对象（如果池中不存在这个字符串的话）。
        System.out.println("str1 = " + str1);

        boolean equals = str.equals(str1);
        System.out.println("equals = " + equals); //true

        boolean b = str == str1;
        System.out.println("b = " + b); //false

        String str2 = "xy";
        String str3 = "xy";
        boolean b1 = str2 == str3;
        System.out.println("b1 = " + b1); //true
        // 在创建字符串常量时，首先坚持字符串常量池是否存在该字符串。
        // 存在该字符串，返回引用实例。
        // 若不存在，则实例化该字符串并放入池中。

        String s3 = new String("1") + new String("1");
        s3.intern();

        String s4 = "11";

        boolean b2 = s3 == s4;
        System.out.println("b2 =  "+b2); //true
        // s3.intern()，这一行代码时，是将s3中的“11”字符串放入字符串常量池中。
        // s4 直接从字符串常量池中取值。

        //Java1.7 字符串常量池在堆区
    }
}
