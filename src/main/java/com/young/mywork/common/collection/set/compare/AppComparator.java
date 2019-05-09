package com.young.mywork.common.collection.set.compare;

import java.util.Comparator;

/**
 * Author 10248
 * Date 2019/5/9 9:06
 * Description
 */
public class AppComparator implements Comparator<App2> {
    @Override
    public int compare(App2 o1, App2 o2) {
        int compare = o1.getName().length() - o2.getName().length();

        return compare == 0 ? o1.getAge() - o2.getAge() : compare;
    }
}
