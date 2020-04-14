package singleton;

/**
 * 描述：懒汉式（线程不安全）（不推荐）
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }

}
