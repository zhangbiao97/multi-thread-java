package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify、notifyAll。start先执行并不代表线程先启动。
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class WaitNotifyAll implements Runnable {

    private static final Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName() + "waits to start.");
                object.wait();
                System.out.println(Thread.currentThread().getName() + "s waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll runnable = new WaitNotifyAll();
        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        Thread threadC = new Thread(() -> {
            synchronized (object) {
                object.notifyAll();
                //object.notify();
                System.out.println("ThreadC notified.");
            }
        });
        threadA.start();
        threadB.start();
        //Thread.sleep(1000);
        threadC.start();
    }

}
