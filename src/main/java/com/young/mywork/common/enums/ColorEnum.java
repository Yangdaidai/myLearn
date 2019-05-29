package com.young.mywork.common.enums;

/**
 * Author 10248
 * Date 2019/5/29 13:58
 * Description
 */
public enum ColorEnum {
    //每个枚举变量都是枚举类ColorEnum的实例，相当于RED=new ColorEnum（1），按序号来。
    //每个成员变量都是final static修饰
    RED, GREEN, BLACK, YELLOW;

    public static void main(String[] args) {
        for (ColorEnum color : ColorEnum.values()) {
            //ordinal返回枚举变量的序号
            System.out.println(color + ", ordinal : " + color.ordinal() + ",name : " + color.name());
        }
    }
}

