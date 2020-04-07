package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：两个线程交替打印0~100的奇偶数，用wait和notify。
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class WaitNotifyPrintOddEvenWait {

    private static int count = 0;

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TurningRunner(), "偶数").start();
        Thread.sleep(1000);
        new Thread(new TurningRunner(), "奇数").start();
    }

    /**
     * 1、拿到锁，我们就打印
     * 2、打印完，唤醒其他线程，自己就休眠
     */
    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            //如果任务还没有结束，就让出当前的锁并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

}