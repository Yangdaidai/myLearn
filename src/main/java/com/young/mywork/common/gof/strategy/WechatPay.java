package com.young.mywork.common.gof.strategy;

import com.young.mywork.common.gof.inter.PayStrategy;

/**
 * Author 10248
 * Date 2019/5/14 21:01
 * Description
 */
public class WechatPay implements PayStrategy {
    @Override
    public void pay(double total) {
        System.out.println("pay with wechatpay: " + total);
    }
}
