package thread.core.startthread;

/**
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
