package background;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/28 18:33
 * @description: 发布逸出   解决方法：返回副本
 */
public class MultiThreadsError3 {
    private Map<String, String> states;

    public MultiThreadsError3() {
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
    }

    public Map<String, String> getStates() {
        return states;
    }

    public Map<String, String> getStatesImproved() {
        return new HashMap<>(states);
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        //       Map<String, String> states = multiThreadsError3.getStates();
//        System.out.println(states.get("1"));
//        states.remove("1");
//        System.out.println(states.get("1"));
        System.out.println(multiThreadsError3.getStatesImproved());
        multiThreadsError3.getStatesImproved().remove("1");
        System.out.println(multiThreadsError3.getStatesImproved().get("1"));
        System.out.println(multiThreadsError3.getStates());
    }
}
