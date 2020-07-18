package threadcoreknowledge.startthread;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 16:10
 * @description: 演示不能调用两次start方法，否则会报错
 */
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

    }
}
