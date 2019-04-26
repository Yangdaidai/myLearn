package com.young.MyWork;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void testMapAndFlatMap() {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        String w ="hello";
        String[] split = w.split("");
        for (String s : split) {
            System.out.println(s);
        }


        List<String> stringList = words.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());

     //   System.out.println(stringList);
     //   stringList.forEach(s -> System.out.println(s));

    }
}