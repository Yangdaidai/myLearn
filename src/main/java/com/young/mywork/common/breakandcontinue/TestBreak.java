package com.young.mywork.common.breakandcontinue;

import java.util.ArrayList;
import java.util.List;

public class TestBreak {

    public static void main(String[] args) {



        List<String> answerList=new ArrayList<>(3);    //定义集合存储小明的回答
        answerList.add("y");
        answerList.add("n");
        answerList.add("no");

        String answer;    //一圈100米，1000米为10圈，即为循环的次数
        for(int i=0;i<answerList.size();i++) {
            System.out.println("跑的是第"+(i+1)+"圈");
            System.out.println("还能坚持吗？");    //获取小明的回答
            answer=answerList.get(i);    //判断小明的回答是否为y？如果不是，则放弃，跳出循环
            if(!answer.equals("y")) {
                System.out.println("放弃");
                break;
            }

            System.out.println("加油！继续！");
        }

    }
}
