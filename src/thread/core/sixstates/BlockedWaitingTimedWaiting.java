package thread.core.sixstates;

/**
 * 描述：展示Blocked、Waiting、TimedWaiting。
 * <p>
 * Create By ZhangBiao
 * 2020/4/6
 */
public class BlockedWaitingTimedWaiting implements Runnable {

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Timed_Waiting状态，因为正在执行Thread.sleep(1000)
        System.out.println(thread1.getState());
        //打印出Blocked状态，因为thread2想拿得到sync()的锁却拿不到
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Waiting状态，因为执行了wait()
        System.out.println(thread1.getState());
    }

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync() {
        try {
            Thread.sleep(1000);
            super.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
