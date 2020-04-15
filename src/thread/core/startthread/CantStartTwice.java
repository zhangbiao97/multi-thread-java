package thread.core.startthread;

/**
 * 描述：start多次。
 *
 * Create By ZhangBiao
 * 2020/4/4
 */
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }

}
