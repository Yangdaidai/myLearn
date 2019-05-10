package com.young.mywork.common.reference;

import org.junit.Test;

import java.lang.ref.WeakReference;

import static org.junit.Assert.*;

public class StrongReferenceTest {

    @Test
    public void testStrongReference(){
        Object reference=new Object();

        /**
         * 通过赋值创建 StrongReference
         */
        Object strongReference=reference;
        assertSame(reference,strongReference);

        reference = null;
        System.gc();

        /**
         * StrongReference 在 GC 后不会被回收
         */
        assertNotNull(strongReference);
    }

    @Test
    public void testWeakReference() {
        Object referent = new Object();
        WeakReference<Object> weakRerference = new WeakReference<Object>(referent);

        assertSame(referent, weakRerference.get());

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        assertNull(weakRerference.get());
    }
}
