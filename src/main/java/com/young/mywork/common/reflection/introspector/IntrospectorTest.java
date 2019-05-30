package com.young.mywork.common.reflection.introspector;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Author 10248
 * Date 2019/5/30 11:26
 * Description
 */
public class IntrospectorTest {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {

            descriptor.setValue("name","yang dai dai");
            descriptor.setValue("age",18);
            descriptor.setValue("sex",false);
            descriptor.setValue("id",11999);

            String writeMethod = descriptor.getWriteMethod().getName();
            System.out.println("writeMethod = " + writeMethod);

            String name = descriptor.getName();
            Object value = descriptor.getValue(name);
            System.out.println("property = " + name + " value = " + value);
        }

        User user = new User();
        PropertyDescriptor name = new PropertyDescriptor("name", User.class);
        PropertyDescriptor id = new PropertyDescriptor("id", User.class);

        name.getWriteMethod().invoke(user,"王小二");
        id.getWriteMethod().invoke(user,999);
        System.out.println("user = " + user);
    }
}
