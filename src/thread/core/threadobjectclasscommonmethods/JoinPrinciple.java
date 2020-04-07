package thread.core.threadobjectclasscommonmethods;

/**
 * 描述：通过讲解join原理，分析出join的代替写法。
 * <p>
 * Create By ZhangBiao
 * 2020/4/7
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        //thread.join();
        synchronized (thread) {
            thread.wait();
        }
        System.out.println("子线程运行完毕！");
    }

}
