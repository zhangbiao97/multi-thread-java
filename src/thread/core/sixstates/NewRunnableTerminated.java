package thread.core.sixstates;

/**
 * 描述：展示线程的NEW、RUNNABLE、Terminated状态。
 * 即使是正在运行，也是Runnable状态，而不是Running。
 * <p>
 * Create By ZhangBiao
 * 2020/4/6
 */
public class NewRunnableTerminated implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW状态
        System.out.println(thread.getState());
        thread.start();
        //打印出RUNNABLE状态
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE状态，即使是正在运行，也是RUNNABLE，而不是RUNNING
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Terminated状态
        System.out.println(thread.getState());
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

}
