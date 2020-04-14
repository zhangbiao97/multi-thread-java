package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：不适用于volatile的场景。
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class NoVolatile implements Runnable {

    volatile int a;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile r = new NoVolatile();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(r.a);
        System.out.println(r.realA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
            realA.incrementAndGet();
        }
    }
}
