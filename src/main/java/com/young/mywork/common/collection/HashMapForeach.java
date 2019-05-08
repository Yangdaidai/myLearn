package com.young.mywork.common.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapForeach {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("yang chang",20);
        hashMap.put("王小二",18);

        hashMap.forEach((s, integer) -> System.out.println("name is : "+s+" age is : "+integer));

        Set<String> stringSet = hashMap.keySet();
        for (String s : stringSet) {
            System.out.println("name : "+s+ " age : "+hashMap.get(s));
        }

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();

        for (Map.Entry entry : entrySet){
            System.out.println("name : "+entry.getKey()+" age : "+entry.getValue());
        }

    }
}
