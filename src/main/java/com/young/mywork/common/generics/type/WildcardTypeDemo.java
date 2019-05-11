package com.young.mywork.common.generics.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/11 17:25
 * Description
 */
public class WildcardTypeDemo {
    private List<? extends Number> list;
    private List<? super Integer> list1;

    public static void main(String[] args) throws NoSuchFieldException {
        Field list = WildcardTypeDemo.class.getDeclaredField("list");
        Type genericType = list.getGenericType();
        ParameterizedType type = (ParameterizedType) genericType;
        Type[] actualTypeArguments = type.getActualTypeArguments();
        String name = actualTypeArguments[0].getClass().getName();
        //name = sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
        System.out.println("name = " + name);

        WildcardType type1 = (WildcardType) actualTypeArguments[0];
        Type[] upperBounds = type1.getUpperBounds();
        Type[] lowerBounds = type1.getLowerBounds();

        //upperBounds = class java.lang.Number
        System.out.println("upperBounds = " + upperBounds[0]);
//        System.out.println("lowerBounds = " + lowerBounds[0]);
    }
}
