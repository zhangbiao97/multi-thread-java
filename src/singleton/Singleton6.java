package singleton;

/**
 * 描述：双重检查（推荐面试使用）
 * <p>
 * Create By ZhangBiao
 * 2020/4/14
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }

}
