package com.young.mywork.stream.model;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public
class Order {
    private String orderId;
    private String userId;
    private int amount;
}
