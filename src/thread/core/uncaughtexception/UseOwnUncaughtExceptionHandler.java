package thread.core.uncaughtexception;

/**
 * 描述：使用自定义CaughtExceptionHandler
 * <p>
 * Create By ZhangBiao
 * 2020/4/8
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));
        new Thread(new UseOwnUncaughtExceptionHandler()).start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler()).start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler()).start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler()).start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
