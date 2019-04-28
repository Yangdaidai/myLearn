package com.young.mywork.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlatMapTest {



    public static void main(String[] args) {

        Student student = new Student();
        if (Objects.isNull(student)){
            System.out.println("student is null !");
        }else {
            System.out.println("student");
        }

        String[] strings = {"Hello", "World"};



        List<String> stringList = Arrays.asList(strings).stream().flatMap(s-> Arrays.stream(strings))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(" stringList "+stringList);

        String[] string1 = {"Hello", "World"};
        String[] string2 = {"Hello", "Tom"};
        ArrayList<String[]> arrayList = new ArrayList<>();
        arrayList.add(string1);
        arrayList.add(string2);

        List<String> list = arrayList.stream().flatMap(Arrays::stream).distinct().sorted().collect(Collectors.toList());

        System.out.println("list "+list);

        List<String> houseList = new ArrayList<>(10);

        houseList.add("公寓");
        houseList.add("别墅");
        houseList.add("双拼");

        String nameStr = String.join("/", houseList);

        System.out.println("Chinese type is "+nameStr);

    }
}
