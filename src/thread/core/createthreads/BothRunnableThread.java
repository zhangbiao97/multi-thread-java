package thread.core.createthreads;

/**
 * 描述：同时使用Runnable和Thread两种实现线程的方式
 * <p>
 * Create By ZhangBiao
 * 2020/4/4
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("我来自Runnable");
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thead");
            }
        }.start();
    }

}
