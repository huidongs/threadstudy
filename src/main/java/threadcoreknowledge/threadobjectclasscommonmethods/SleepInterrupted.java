package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 20:31
 * @description: 每一秒输出当前时间，被中断，观察
 * Thread.sleep()
 * TimeUnit.SECONDS.sleep()
 */
public class SleepInterrupted implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(new Date());
            try {
                TimeUnit.HOURS.sleep(1);
                TimeUnit.MINUTES.sleep(1);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(6000);
        thread.interrupt();
    }
}
