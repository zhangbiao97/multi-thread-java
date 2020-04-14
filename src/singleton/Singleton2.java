package singleton;

/**
 * 描述：饿汉式（静态代码块）（可用）
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class Singleton2 {

    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

}
