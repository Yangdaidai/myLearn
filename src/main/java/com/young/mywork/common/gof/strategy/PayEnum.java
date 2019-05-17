package com.young.mywork.common.gof.strategy;

public enum PayEnum {
    ALIPAY("com.young.mywork.common.gof.strategy.Alipay"),
    WECHATPAY("com.young.mywork.common.gof.strategy.WechatPay"),
    EBANKPAY("com.young.mywork.common.gof.strategy.EbankPay");

    private String className;

    PayEnum(String className) {
        this.setClassName(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
