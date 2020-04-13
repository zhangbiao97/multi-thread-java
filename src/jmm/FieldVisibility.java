package jmm;

/**
 * 描述：演示可见性带来的问题。
 * <p>
 * Create By ZhangBiao
 * 2020/4/13
 */
public class FieldVisibility {

    int a = 1;
    volatile int b = 2;

    public static void main(String[] args) {
        while (true) {
            FieldVisibility test = new FieldVisibility();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.change();
            }).start();
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.print();
            }).start();
        }
    }

    private void print() {
        System.out.println("b = " + b + ",a = " + a);
    }

    /**
     * 1、3,3
     * 2、1,2
     * 3、3,2
     */
    private void change() {
        a = 3;
        b = a;
    }

}
