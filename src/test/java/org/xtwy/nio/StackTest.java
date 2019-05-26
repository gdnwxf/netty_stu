package org.xtwy.nio;

import java.lang.reflect.Method;

/**
 * #author qinghao
 * #date 2019-05-25 11:35
 */
public class StackTest {

    public static void main(String[] args) throws NoSuchMethodException {
        RuntimeException runtime = new RuntimeException("dsad");

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (int i = 0; i < stackTrace.length; i++) {
            System.out.println(stackTrace[i]);
        }

        Method targt1 = StackTest.class.getMethod("targt1");
        Method targt2 = StackTest.class.getMethod("targt2");
        System.out.println(targt1 == targt2);
        StackTest.class.getMethod("targt1");
    }

    public static void targt1(){};
    public static void targt2(){};
}
