package com.young.mywork.common.generics.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/11 15:18
 * Description
 */
public class ParameterizedTypeDemo<T> {
    //ParameterizedType表示参数化类型，也就是泛型，例如List<T>、Set<T>等；

    private List<T> list;
   private HashMap<String, Integer> hashMap;

    public static void main(String[] args) throws NoSuchFieldException {
        Field list = ParameterizedTypeDemo.class.getDeclaredField("list");
        //获取该属性的泛型类型
        Type genericType = list.getGenericType();
        System.out.println("genericType = " + genericType);
        //获取实际的Type类型
        //name = sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        String name = genericType.getClass().getName();
        System.out.println("name = " + name);

        Field hashMap = ParameterizedTypeDemo.class.getDeclaredField("hashMap");
        ParameterizedType parameterizedType = (ParameterizedType) hashMap.getGenericType();
        //parameterizedType = java.util.HashMap<java.lang.String, java.lang.Integer>
        System.out.println("parameterizedType = " + parameterizedType);
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            //actualTypeArgument = class java.lang.String
            //actualTypeArgument = class java.lang.Integer
            System.out.println("actualTypeArgument = " + actualTypeArgument);
        }

        Type rawType = parameterizedType.getRawType();
        //获取声明泛型的类或者接口，也就是泛型中<>前面的那个值;
        //rawType = class java.util.HashMap
        System.out.println("rawType = " + rawType);

        //“拥有者”表示的含义--内部类的“父类”，通过getOwnerType()方法可以获取到内部类的“拥有者”；
        // 例如： Map  就是 Map.Entry<String,String>的拥有者；
        Type ownerType = parameterizedType.getOwnerType();
        System.out.println("ownerType = " + ownerType);

    }


}
