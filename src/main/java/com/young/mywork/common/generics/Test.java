package com.young.mywork.common.generics;

/**
 * Author 10248
 * Date 2019/5/10 20:47
 * Description
 */
public class Test<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Test<String> stringTest = new Test<>();
        stringTest.setT("good");
        System.out.println(stringTest.getT());

        //通过上面的2个例子，我们不仅产生疑问，ArrayList中声明了类型转换，Test中没有声明，
        // 但是两者在运行期间都没有报错？那么ArrayList的声明意义何在呢 ?当再次查看ArrayList源码时发现，
        // elementData对象实际上是一个Object类型数组，当我们获取元素并返回的时候，
        // 编译器会根据方法的返回值进行类型安全检查，所以 return (E) elementData[index]才会有强制类型转换的情况；
        //

        //JVM虚拟机在真正执行get方法的时候，实际上隐式的为我们的代码进行了类型转换操作，
        // 就好比在代码中直接声明String ss = (String)test.getT()、String sss = (String)list.get(0)一样；
        //checkcast虚拟机指令:
        //checkcast：“检验类型转换，检验未通过将抛出ClassCastException”；

        //由于泛型擦除机制的存在，在运行期间无法获取关于泛型参数类型的任何信息，
        // 自然也就无法对类型信息进行操作；例如：instanceof 、创建对象等；
    }
}
