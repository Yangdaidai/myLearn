package com.young.mywork.common.thread.threadlocal;

/**
 * Author 10248
 * Date 2019/5/21 16:16
 * Description
 */
public class ThreadLocalDemo implements Runnable {
    /**
     * ThreadLocal使用场景
     * （1）每个线程都需要维护一个自己专用的线程的上下文变量，比如计数器，jdbc链接，web开发里面的session，事务id等。
     * （2）包装一个线程不安全的成员变量，给其提供一个线程安全的环境，比如Java里面的SimpleDateFormat是线程不安全的，所以在多线程下使用可以采用ThreadLocal包装，从而提供安装的访问。
     * （3）对于一些线程级别，传递方法参数有许多层的时候，我们可以使用ThreadLocal包装，只在特定地方set一次，然后不管在什么地方都可以随便get出来，从而巧妙了避免了多层传参。
     * <p>
     * ThreadLocal的原理
     * ThreadLocal的原理内部可以理解成是一个map对象，它的key可以理解成是线程本身，value就是我们存的对象，所以在多线程场景下，每个线程操作的都是自己对应的变量，所以不会存在并发冲突问题。
     * 需要ThreadLocal并不是替换Java里面同步操作的，它的使用场景非常有限，在一定特定的情况下可以发挥比较棒的作用，比如在Spring和Hibernate框架中就大量采用了ThreadLocal来保存事务会话。但有优点就必有缺点。ThreadLocal使用不当会造成内存泄漏，尽管ThreadLocalMap的Key对象继承了WeakReference 对象，能够确保在内存空间不足的时候来回收对象，但这仅仅是Map的key，而我们的Value值其实是强引用，所以在一个线程生命周期结束的时候，如果调用remove方法来移除本身，那么就可能会造成内存泄漏，这一点需要注意。
     * 所以最好的避免内存泄漏的办法是在线程结束之前，手动调用remove方法或者set（null），从而移除ThreadLocal的key对象或者将key对象设置为null，这样以来就比较优雅的避免了内存泄漏的问题。
     */

    private static ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        try {
            //set值时通过ThreadLocalMap
            // key : 当前线程 ; value : System.currentTimeMillis()
            startTimeThreadLocal.set(System.currentTimeMillis());
            Long startTime = startTimeThreadLocal.get();
            Thread.sleep(100L);
            System.out.println(" someMethod is running!");
            Long endTime = System.currentTimeMillis();
            System.out.println("current thread "+Thread.currentThread().getName()+" method take time  = " + (endTime - startTime)+"毫秒");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws InterruptedException {

        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        Thread thread = new Thread(threadLocalDemo);
        thread.start();
        Thread.sleep(1000L);

        Thread thread1 = new Thread(threadLocalDemo);
        thread1.start();


    }
}
