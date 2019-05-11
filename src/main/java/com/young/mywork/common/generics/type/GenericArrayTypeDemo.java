package com.young.mywork.common.generics.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/11 15:51
 * Description
 */
public class GenericArrayTypeDemo<T> {
    //泛型数组类型，例如List<String>[] 、T[]等；

    private T[] t;
    private List<String>[] listArray;

    public static void main(String[] args) throws NoSuchFieldException {
        Field listArray = GenericArrayTypeDemo.class.getDeclaredField("listArray");
        Type genericType = listArray.getGenericType();
        String name = genericType.getClass().getName();
        //泛型数组类型
        //name = sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
        System.out.println("name = " + name);

        GenericArrayType genericArrayType = (GenericArrayType) genericType;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        //genericComponentType = java.util.List<java.lang.String>

        //返回泛型数组中元素的Type类型，即List<String>[] 中的 List<String>（ParameterizedTypeImpl）、
        //T[] 中的T（TypeVariableImpl）
        System.out.println("genericComponentType = " + genericComponentType);
    }
}
