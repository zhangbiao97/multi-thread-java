package background;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：构造函数中新建线程。
 * <p>
 * Create By ZhangBiao
 * 2020/4/9
 */
public class MultiThreadsError6 {

    private Map<String, String> states;

    public MultiThreadsError6() {
        new Thread(() -> {
            this.states = new HashMap<>();
            states.put("1", "周一");
            states.put("2", "周二");
            states.put("3", "周三");
            states.put("4", "周四");
        }).start();
    }

    public Map<String, String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsError6 multiThreadsError6 = new MultiThreadsError6();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(multiThreadsError6.getStates().get("1"));
    }
}
