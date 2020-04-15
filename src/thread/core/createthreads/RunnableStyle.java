package thread.core.createthreads;

/**
 * 描述：实现Runnable接口实现线程。
 * <p>
 * Create By ZhangBiao
 * 2020/4/4
 */
public class RunnableStyle implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口实现");
    }

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }

}
