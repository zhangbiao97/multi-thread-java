package background;

/**
 * 描述：初始化未完毕，就this赋值。
 * <p>
 * Create By ZhangBiao
 * 2020/4/9
 */
public class MultiThreadsError4 {
    static Point point;

    public static void main(String[] args) {
        new PointMaker().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (point != null) {
            System.out.println(point);
        }
    }
}

class Point {
    private final int x, y;


    Point(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadsError4.point = this;
        Thread.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

class PointMaker extends Thread {

    @Override
    public void run() {
        try {
            new Point(1, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}