package com.young.mywork.common.breakandcontinue;

import java.util.Arrays;
import java.util.List;

public class TestContinue {

    public static void main(String[] args) {


        int score;    //记录课程的分数
        int count = 0;    //记录成绩大于等于80分的人数
        List<Integer> scoreList = Arrays.asList(30, 20, 10, 20, 50, 40, 60,80, 90);
        for (int i = 0; i < scoreList.size(); i++) {
            score = scoreList.get(i);
            if (score < 80) {    //判断用户录入的学生成绩是否小于80
                System.out.println("第" + (i + 1) + "位学生的Java成绩：" + score);
                continue;    //如果小于80，跳过本次循环，继续下次循环
            }
            count++;    //如果用户录入的分数大于等于80，则人数加1
        }
        System.out.println("Java 成绩在 80 分以上的学生人数为：" + count);
    }
}
