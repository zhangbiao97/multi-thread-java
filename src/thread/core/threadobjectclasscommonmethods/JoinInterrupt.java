package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：演示join期间被中断的效果。
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class JoinInterrupt {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                mainThread.interrupt();
                Thread.sleep(10000);
                System.out.println("Thread1 finished");
            } catch (InterruptedException e) {
                System.out.println("子线程被中断了！");
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "主线程被中断了！");
            thread.interrupt();
        }
        System.out.println("子线程运行完毕！");
    }

}
