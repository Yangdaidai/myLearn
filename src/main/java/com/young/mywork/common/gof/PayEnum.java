package com.young.mywork.common.gof;

public enum PayEnum {
    ALIPAY("com.young.mywork.common.gof.Alipay"),
    WECHATPAY("com.young.mywork.common.gof.WechatPay"),
    EBANKPAY("com.young.mywork.common.gof.EbankPay");

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
