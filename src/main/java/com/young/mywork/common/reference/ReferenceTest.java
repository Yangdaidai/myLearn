package com.young.mywork.common.reference;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static org.junit.Assert.*;

/**
 * Author 10248
 * Date 2019/5/24 11:04
 * Description
 */
public class ReferenceTest {

    //    四种引用:

    //强引用
    @Test
    public void testStrongReference() {
        Object reference = new Object();

        /**
         * 通过赋值创建强引用 StrongReference
         */
        Object strongReference = reference;
        assertSame(reference, strongReference);

        reference = null;
        System.gc();

        /**
         * StrongReference 在 GC 后不会被回收
         */

        //1.强引用可以直接访问目标对象 ;
        //
        //2.强引用所指向的对象在任何时候都不会被系统回收 ;
        //
        //3.由于2的原因,强引用可能导致内存泄漏。
        assertNotNull(strongReference);
    }

    //弱引用
    @Test
    public void testWeakReference() {
        Object referent = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(referent);

        assertSame(referent, weakReference.get());

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         *  一个弱引用,  当所引用的对象在 JVM 内不再有强引用时, GC 后 weak reference 将会被自动回收
         */
        assertNull(weakReference.get());
    }

    //软引用
    @Test
    public void testSoftReference() {

        Object reference = new Object();
        SoftReference<Object> softReference = new SoftReference<>(reference);
        assertNotNull(softReference);
        reference = null;
        System.gc();

        //
        // SoftReference 会尽可能长的保留引用直到 JVM 内存不足时才会被回收(虚拟机保证),
        // 这一特性使得 SoftReference 非常适合缓存应用
        assertNotNull(softReference);

    }

    //虚引用
    @Test
    public void testPhantomReferenceAlwaysNull(){
        Object referent = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<>(referent, new ReferenceQueue<>());

        /**
         * phantom reference 的 get 方法永远返回 null
         * 虚引用的主要作用是跟踪对象被垃圾回收的状态。
         */
        assertNull(phantomReference.get());
    }
}
