package com.young.mywork.common.generics.type;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/11 16:27
 * Description
 */
public class TypeVariableDemo<T extends String & Serializable> {
    //泛型的类型变量，指的是List<T>、Map<K,V>中的T，K，V等值，实际的Java类型是TypeVariableImpl（TypeVariable的子类）；
    // 此外，还可以对类型变量加上extend限定，这样会有类型变量对应的上限；

    //我们看到，如果不在Class上定义，属性上并不能直接使用！所以，这也是我之前说的属性上并不是定义泛型，
    // 而是使用泛型，所以Field并没有实现GenericDeclaration接口！
    private T t;
    private List<T> list;

    public void test(T t) {
        System.out.println("t = " + t);
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Field list = TypeVariableDemo.class.getDeclaredField("list");
        Type genericType = list.getGenericType();
        ParameterizedType type = (ParameterizedType) genericType;
        Type[] actualTypeArguments = type.getActualTypeArguments();
        Type actualTypeArgument = actualTypeArguments[0];
        //actualTypeArgument = T
        System.out.println("actualTypeArgument = " + actualTypeArgument.getTypeName());
        String name = actualTypeArgument.getClass().getName();
        //name = sun.reflect.generics.reflectiveObjects.TypeVariableImpl
        System.out.println("name = " + name);

        Field t = TypeVariableDemo.class.getDeclaredField("t");

        TypeVariable typeVariable = (TypeVariable) t.getGenericType();
        //上界
        Type[] bounds = typeVariable.getBounds();
        for (Type bound : bounds) {
            System.out.println("bound = " + bound);
        }

    }
}
