package com.young.mywork.common.generics.type;

/**
 * Author 10248
 * Date 2019/5/11 14:49
 * Description
 */
public class TypeDemo {
     // Type 的子类

    //1. ParameterizedTypeDemo  参数化类型，即泛型；例如：List<T>、Map<K,V>等带有参数化的对象;

    //2.TypeVariable  类型变量，即泛型中的变量；例如：T、K、V等变量，可以表示任何类；在这需要强调的是，
    // TypeVariable代表着泛型中的变量，而ParameterizedType则代表整个泛型；

    //3.GenericArrayType 泛型数组类型，用来描述ParameterizedType、TypeVariable类型的数组；即List<T>[] 、T[]等；

    //4. Class 与以上三者不同，Class是Type的一个实现类，属于原始类型，是Java反射的基础，对Java类的抽象；

    //5.WildcardType 泛型表达式（或者通配符表达式），即？ extend Number、？ super Integer这样的表达式；
    // WildcardType虽然是Type的子接口，但却不是Java类型中的一种；
}
