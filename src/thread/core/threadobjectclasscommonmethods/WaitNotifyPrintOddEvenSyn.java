package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：两个线程交替打印0~100奇偶数，用synchronized关键字实现
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class WaitNotifyPrintOddEvenSyn {

    private static int count;

    private static final Object lock = new Object();

    /**
     * 1、新建2个线程
     * 2、1个处理偶数，1个处理奇数（用位运算）
     * 3、用synchronized关键字来通信
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "偶数").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "奇数").start();
    }

}
