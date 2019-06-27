package com.young.mywork.common.stream;

import com.young.mywork.common.stream.model.Student;
import com.young.mywork.common.stream.model.StudentComparator;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class MapAndReduceTest {

    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student("刘一", 85));
        stuList.add(new Student("陈二", 90));
        stuList.add(new Student("张三", 98));
        stuList.add(new Student("李四", 88));
        stuList.add(new Student("王五", 88));
        stuList.add(new Student("赵六", 95));
        stuList.add(new Student("孙七", 87));
        stuList.add(new Student("周八", 84));
        stuList.add(new Student("吴九", 100));
        stuList.add(new Student("郑十", 95));

        List<Student> stuList1 = new ArrayList<>(10);
        stuList.add(new Student("刘一一", 80));
        stuList.add(new Student("陈二二", 91));
        stuList.add(new Student("张三三", 92));
        stuList.add(new Student("李四四", 82));
        stuList.add(new Student("王五五", 82));
        stuList.add(new Student("赵六六", 93));
        stuList.add(new Student("孙七七", 84));
        stuList.add(new Student("周八八", 84));
        stuList.add(new Student("吴九九", 100));
        stuList.add(new Student("郑十十", 95));
        List<List<Student>> list = new ArrayList<>(20);
        list.add(stuList);
        list.add(stuList1);

        //使用map方法获取list数据中的name的长度
         List<Integer> length = stuList.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
         System.out.println(length);

        //将每人的分数-10
        List<Integer> score = stuList.stream().map(Student::getScore).map(s -> s - 10).collect(Collectors.toList());
        // System.out.println(score);

        //计算学生总分
        //  Integer totalScore = stuList.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
        //  Integer totalScore = stuList.stream().map(Student::getScore).reduce(Integer::sum).get();
        //  System.out.println("totalScore = " + totalScore);

        //计算最高分和最低分
        Integer max = stuList.stream().map(Student::getScore).reduce(Integer::max).orElse(0);
        System.out.println("max = " + max);

        //自定义比较器 --> StudentComparator
        List<Student> studentList = stuList.stream().sorted(new StudentComparator()).collect(Collectors.toList());
        System.out.println("studentList : "+studentList);

        //   Integer min = stuList.stream().map(Student::getScore).reduce(Integer::min).orElse(0);
        //   System.out.println("min = " + min);

        //   Integer min = stuList.stream().map(Student::getScore).min(Integer::compareTo).orElse(0);
        //   System.out.println("min = " + min);

        List<Integer> scoreList = list.stream().flatMap(Collection::stream).map(Student::getScore).distinct().sorted().collect(Collectors.toList());
        scoreList.forEach(System.out::println);

        // toMap
        Map<String, Integer> scoreMap = stuList.stream().filter(student -> StringUtils.isNotBlank(student.getName())).collect(Collectors.toMap(Student::getName, Student::getScore));

        scoreMap.forEach((s, integer) -> System.out.println("name: "+s+" score: "+integer));
    }
}
