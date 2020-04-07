package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：证明wait只释放当前的那把锁。
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class WaitNotifyReleaseOwnMonitor {

    private static volatile Object resourceA = new Object();

    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("ThreadA got resourceA lock.");
                synchronized (resourceB) {
                    System.out.println("ThreadA got resourceB lock.");
                    try {
                        System.out.println("ThreadA releases resourceA lock.");
                        resourceA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA) {
                System.out.println("ThreadB got resourceA lock.");
                System.out.println("ThreadB tries to resourceB lock.");
                synchronized (resourceB) {
                    System.out.println("ThreadB got resourceB lock.");
                }
            }
        });
        threadA.start();
        threadB.start();
    }


}
