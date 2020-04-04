package thread.core.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述：使用定时器创建线程
 * <p>
 * Create By ZhangBiao
 * 2020/4/4
 */
public class DemoTimmerTask {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);

    }
}
