package com.young.mywork.common.breakandcontinue;

import java.util.ArrayList;
import java.util.List;

/**
 * Author 10248
 * Date 2019/5/17 15:55
 * Description
 */
public class Break1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(18);
        list.add(17);
        list.add(22);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(20)){
                System.out.println("值等于20的元素为 : "+list.get(i));
                break; //使用 break 语句直接强行退出循环
            }
            System.out.println("list = " + list.get(i));
        }
    }
}
