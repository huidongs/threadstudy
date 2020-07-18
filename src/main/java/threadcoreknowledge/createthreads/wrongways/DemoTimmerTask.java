package threadcoreknowledge.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 11:14
 * @description: 定时器创建线程
 */
public class DemoTimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);

    }
}
