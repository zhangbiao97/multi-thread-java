package thread.core.stopthread;

/**
 * 描述：run无法抛出check Exception，只能用try/catch。
 * <p>
 * Create By ZhangBiao
 * 2020/4/5
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            
        });
    }

}
