package com.young.mywork.common.stream;


import com.young.mywork.common.stream.model.Order;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ListStreamTest {
    private static List<Order> getOrders() {
        String orderId1 = "2321837281372913";
        String userId1 = "20180701001";
        int amount1 = 100;

        String orderId2 = "2321837281372914";
        String userId2 = "20180701002";
        int amount2 = 100;

        String orderId3 = "2321837281372912";
        String userId3 = "20180701003";
        int amount3 = 1005;

        String orderId4 = "2321837281372918";
        String userId4 = "20180701005";
        int amount4 = 880;


        String orderId5 = "2321837281372918";
        String userId5 = "20180701004";
        int amount5 = 99;

        Order order = new Order();
        order.setUserId(userId1);
        order.setOrderId(orderId1);
        order.setAmount(amount1);

        Order order1 = new Order();
        order1.setOrderId(orderId2);
        order1.setUserId(userId2);
        order1.setAmount(amount2);

        Order order2 = new Order();
        order2.setOrderId(orderId3);
        order2.setUserId(userId3);
        order2.setAmount(amount3);

        Order order3 = new Order();
        order3.setOrderId(orderId4);
        order3.setUserId(userId4);
        order3.setAmount(amount4);

        Order order4 = new Order();
        order4.setOrderId(orderId5);
        order4.setUserId(userId5);
        order4.setAmount(amount5);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        return orderList;
    }

    public static void main(String[] args) {

        List<Order> orderList = getOrders();

        //1.jdk8 lambda排序，带参数类型
        //  orderList.sort((Order ord1, Order ord2) -> ord2.getOrderId().compareTo(ord1.getOrderId()));

        //2.jdk8 lambda排序，不带参数类型
        // orderList.sort((ord1, ord2) -> ord2.getOrderId().compareTo(ord1.getOrderId()));

        //3.jdk8 升序排序，Comparator提供的静态方法
        //  Collections.sort(orderList, Comparator.comparing(Order::getOrderId));

        //4.jdk8 降序排序，Comparator提供的静态方法
        //  Collections.sort(orderList, Comparator.comparing(Order::getOrderId).reversed());

        //5.jdk8 组合排序，Comparator提供的静态方法，先按orderId排序，orderId相同的按amount排序
        orderList.sort(Comparator.comparing(Order::getOrderId).thenComparing(Order::getAmount).reversed());

        orderList.forEach(str -> System.out.println(str.getOrderId() + "/" + str.getAmount()));

        //按"/"分割
        String ids = orderList.stream().map(Order::getOrderId).collect(Collectors.joining("/"));
        System.out.println("ids = " + ids);

        //串行流与并行流
        long startTime = System.nanoTime();
        List<Order> orderList1 = orderList.stream().sorted(Comparator.comparing(Order::getAmount).reversed()).collect(Collectors.toList());
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(String.format("parallel sort took: %d ms", millis));


        long startTime1 = System.nanoTime();
        List<Order> orderList2 = orderList.parallelStream().sorted(Comparator.comparing(Order::getAmount).reversed()).collect(Collectors.toList());
        long endTime1 = System.nanoTime();
        long millis1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

    }


}
