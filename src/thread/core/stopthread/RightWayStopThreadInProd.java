package thread.core.stopthread;

/**
 * 描述：最佳实践：catch了InterruptedException之后的优先选择：在方法签名中抛出异常，那么run方法就会强制try/catch。
 * <p>
 * Create By ZhangBiao
 * 2020/4/5
 */
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

}
