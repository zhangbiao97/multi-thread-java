package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 描述：用ThreadMXBean检测死锁。
 * <p>
 * Create By ZhangBiao
 * 2020/4/15
 */
public class ThreadMXBeanDetection implements Runnable {

    int flag = 1;

    static ThreadMXBeanDetection.Account a = new ThreadMXBeanDetection.Account(500);

    static ThreadMXBeanDetection.Account b = new ThreadMXBeanDetection.Account(500);

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBeanDetection r1 = new ThreadMXBeanDetection();
        ThreadMXBeanDetection r2 = new ThreadMXBeanDetection();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        System.out.println("a余额：" + a.balance + "元");
        System.out.println("b余额：" + b.balance + "元");
        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null && deadlockedThreads.length > 0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println("发现死锁：" + threadInfo.getThreadName());
            }
        }
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    public static void transferMoney(ThreadMXBeanDetection.Account from, ThreadMXBeanDetection.Account to, int amount) {
        synchronized (from) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败！");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账" + amount + "元");
            }
        }
    }

    static class Account {

        int balance;

        public Account(int balance) {
            this.balance = balance;
        }
    }

}
