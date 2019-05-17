package com.young.mywork.common.breakandcontinue;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/17 15:55
 * Description
 */
public class Continue1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(6);
        list.add(11);
        list.add(10);
        list.add(20);
        list.add(18);
        list.add(17);
        list.add(22);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(20)){
                System.out.println("值等于20的元素为 : "+list.get(i));
                continue; //中止当前迭代的循环，进入下一次的迭代。
            }
            System.out.println("list = " + list.get(i));
        }
    }
}
