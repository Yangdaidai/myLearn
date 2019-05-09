package com.young.mywork.stream;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
class Order {
    private String orderId;
    private String userId;
    private int amount;
}
