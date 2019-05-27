package com.young.mywork.stream.functions;

import com.young.mywork.stream.model.Student;

import java.util.function.Consumer;

/**
 * Author 10248
 * Date 2019/5/25 12:01
 * Description
 */
public class MyConsumer {

    public static void main(String[] args) {
        Consumer<Student> student=student1 -> System.out.println("name is : "+student1.getName()+"score is : "+student1.getScore());
        student.accept(new Student("angleBaby",99));

    }
}
