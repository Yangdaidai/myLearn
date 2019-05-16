package com.young.mywork.stream.model;

import java.util.Comparator;

/**
 * Author 10248
 * Date 2019/5/9 9:54
 * Description
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
         int name = o1.getName().length() - o2.getName().length();
        return name==0?o1.getScore()-o2.getScore():name;
    }

}
