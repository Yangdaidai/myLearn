package com.young.mywork.common.collection.set.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author 10248
 * Date 2019/5/8 20:18
 * Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class App1 implements Comparable<App1> {
    private String name;
    private Integer age;

    //自定义比较：先比较name的长度，在比较age的大小；
    @Override
    public int compareTo(App1 app) {
        //比较name的长度：
        int compare = this.name.length() - app.name.length();
        return compare == 0 ? this.age - app.age : compare;
    }
}
