package background;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：发布逸出。
 * <p>
 * Create By ZhangBiao
 * 2020/4/9
 */
public class MultiThreadsError3 {

    private Map<String, String> states;


    public MultiThreadsError3() {
        this.states = new HashMap<>();
        states.put("1", "周一");
        states.put("1", "周二");
        states.put("1", "周三");
        states.put("1", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        //Map<String, String> states = multiThreadsError3.getStates();
        //System.out.println(states.get("1"));
        //states.remove("1");
        //System.out.println(states.get("1"));
        System.out.println(multiThreadsError3.getStatesImproved().get("1"));
        multiThreadsError3.getStatesImproved().remove("1");
        System.out.println(multiThreadsError3.getStatesImproved().get("1"));
    }
}
