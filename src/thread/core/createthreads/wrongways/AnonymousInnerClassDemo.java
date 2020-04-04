package thread.core.createthreads.wrongways;

/**
 * 描述：使用匿名内部类的方式
 * <p>
 * Create By ZhangBiao
 * 2020/4/4
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }

}
