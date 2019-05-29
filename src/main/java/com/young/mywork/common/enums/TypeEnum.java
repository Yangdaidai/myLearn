package com.young.mywork.common.enums;

public enum TypeEnum {
    FIREWALL("firewall"),
    SECRET("secret"),
    BALANCE("f5");

    private String typeName;

    TypeEnum(String typeName) {
        this.typeName = typeName;
    }

    public static void main(String[] args) {
        TypeEnum balance = TypeEnum.BALANCE;
        String typeName = balance.typeName;
        System.out.println("typeName = " + typeName);
        String name = balance.name();
        System.out.println("name = " + name);

    }
}
