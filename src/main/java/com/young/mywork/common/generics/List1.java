package com.young.mywork.common.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/10 16:58
 * Description
 */
public class List1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        //泛型的出现解决了类型转换失败的风险问题，它不但简化了代码，还提高了程序的安全性；类型转换的错误提前到编译期解决掉；

        List<String> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        list.add("ai");
        list.add("o");
        System.out.println(list);


        //jdk1.5 推出泛型机制
        //泛型的“擦除”，编译过程检测到该实例没有被使用,才会擦除泛型
        /**
         * public class List1 {
         *     public List1() {
         *     }
         *
         *     public static void main(String[] args) {
         *         List<String> list = new ArrayList();
         *         new ArrayList();
         *         list.add("ai");
         *         list.add("o");
         *         System.out.println(list);
         *     }
         * }
         */


        //当我们声明并使用泛型的时候，编译器会帮助我们进行类型的检查和推断，然而在代码完成编译后的Class文件中，泛型信息却不复存在了，
        // JVM在运行期间对泛型无感知，这样新老代码的兼容性迎刃而解，这也就是Java泛型的擦除；
        //结果显示，当我们执行集合的add方法的时候，泛型类型String已经被擦除，取而代之的是Object类型；
        // 当我们执行get方法的时候，泛型同样不存在，也是被当做Object来返回；
        list.getClass().getMethod("add", Object.class).invoke(list, 250);

        List list1=new ArrayList();

        list1.add(22);
        list1.add("good");
        for (Object o : list1) {
            System.out.println(o);
        }
        System.out.println(list);

    }
}
