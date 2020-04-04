package thread.core.createthreads;

/**
 * 描述：继承Thread实现线程
 * <p>
 * Create By ZhangBiao
 * 2020/4/4
 */
public class ThreadStyle extends Thread {

    @Override
    public void run() {
        System.out.println("继承Thread实现");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
