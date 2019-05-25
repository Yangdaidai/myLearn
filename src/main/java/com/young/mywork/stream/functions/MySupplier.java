package com.young.mywork.stream.functions;

import com.young.mywork.stream.model.Student;

import java.util.function.Supplier;

/**
 * Author 10248
 * Date 2019/5/25 11:38
 * Description
 */
public class MySupplier {
    //    Supplier 接口产生给定泛型类型的实例结果。 与 Function 接口不同，Supplier 接口不接受参数。
    public static void main(String[] args) {
        Supplier<Student> getInstance = Student::new;
        Student student = getInstance.get();
        System.out.println(student);
    }
}
