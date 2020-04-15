package deadlock;

/**
 * 描述：转账时候遇到死锁，一旦打开注释，便会发生死锁。
 * <p>
 * Create By ZhangBiao
 * 2020/4/15
 */
public class TransferMoney implements Runnable {

    int flag = 1;

    static Account a = new Account(500);

    static Account b = new Account(500);

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a余额：" + a.balance + "元");
        System.out.println("b余额：" + b.balance + "元");
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

    public static void transferMoney(Account from, Account to, int amount) {

        class Helper {

            public void transferMoney() {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败！");
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账" + amount + "元");
            }

        }

        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);

        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    new Helper().transferMoney();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    new Helper().transferMoney();
                }
            }
        } else {
            synchronized (lock) {
                synchronized (from) {
                    synchronized (to) {
                        new Helper().transferMoney();
                    }
                }
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
