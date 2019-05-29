package com.young.mywork.common.enums;

/**
 * Author 10248
 * Date 2019/5/29 15:32
 * Description
 */
public enum SeasonEnum {
    SPRING("spring", "春天"),
    SUMMER("summer", "夏天"),
    AUTUMN("autumn", "秋天"),
    WINTER(null, null);

    //构造方法被强制private ,不能通过new去生成对象.
    SeasonEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String name1 = SeasonEnum.SPRING.getName();
        String value1 = SeasonEnum.SPRING.getValue();
        System.out.println("name1 = " + name1);
        System.out.println("value1 = " + value1);

        String name = AUTUMN.name;
        String value = AUTUMN.value;
        System.out.println("name = " + name + "; value = " + value);

        SeasonEnum.WINTER.setName("winter");
        SeasonEnum.WINTER.setValue("冬天");

        SeasonEnum winter = SeasonEnum.WINTER;
        System.out.println(winter);

    }
}
