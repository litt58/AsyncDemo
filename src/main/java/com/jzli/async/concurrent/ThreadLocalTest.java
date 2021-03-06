package com.jzli.async.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * =======================================================
 *
 * @Company 产品技术部
 * @Date ：2018/4/9
 * @Author ：李金钊
 * @Version ：0.0.1
 * @Description ：ThreadLocal使用ThreadLocalMap存储数据，每个线程都有ThreadLocalMap的引用，以ThreadLocal作为key，以实际值作为value。
 *                ThreadLocal真正存放数据的地方，就是线程对象本身。
 *                一个线程可以被多个ThreadLocal关联，每声明一个，就在线程的threadLocals增加为一个键值对，key为 ThreadLocal,而value为具体存放的对象。
 * ========================================================
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            int finalI = i;
            String str = "变量" + finalI;
            new Thread(() -> {
                try {
                    threadLocal1.set(finalI);
                    threadLocal2.set(str);
                    System.out.println(Thread.currentThread().getName() + "存入" + finalI + "," + str);
                    TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                    System.out.println(Thread.currentThread().getName() + "获取" + threadLocal1.get() + "," + threadLocal2.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "线程" + i).start();
        }
    }
}
