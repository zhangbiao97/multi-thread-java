package singleton;

/**
 * 描述：懒汉式（线程不安全）
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

}
