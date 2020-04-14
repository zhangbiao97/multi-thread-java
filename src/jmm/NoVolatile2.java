package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：不适用volatile的场景2
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class NoVolatile2 implements Runnable {

    volatile boolean done = false;

    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile2 r = new NoVolatile2();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(r.done);
        System.out.println(r.realA.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            setDone();
            realA.incrementAndGet();
        }
    }

    private void setDone() {
        done = !done;
    }
}
