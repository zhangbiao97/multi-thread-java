package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：展示线程sleep的时候不释放synchronized的monitor，等sleep时间到了以后，正常结束后才释放锁。
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class SleepDontReleaseMonitor implements Runnable {

    public static void main(String[] args) {
        SleepDontReleaseMonitor runnable = new SleepDontReleaseMonitor();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "退出了同步代码块！");
    }

}
