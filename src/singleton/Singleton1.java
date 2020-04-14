package singleton;

/**
 * 描述：饿汉式（静态常量）（可用）
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
