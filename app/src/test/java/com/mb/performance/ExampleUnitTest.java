package com.mb.performance;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        Object softObject = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<Object>(softObject);
        softObject = null;

        System.gc();
        System.out.println("soft:"+objectSoftReference.get());
        System.out.println("===============================");

        Object weakObject = new Object();
        WeakReference<Object> objectWeakReference = new WeakReference<Object>(weakObject);
        weakObject = null;

        System.gc();
        System.out.println("weak:"+objectWeakReference.get());
    }


}