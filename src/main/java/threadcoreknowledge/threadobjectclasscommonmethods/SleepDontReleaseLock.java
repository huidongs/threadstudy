package threadcoreknowledge.threadobjectclasscommonmethods;

import javax.sound.sampled.FloatControl;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 19:45
 * @description: 演示sleep不释放lock
 */
public class SleepDontReleaseLock implements Runnable {
    private static final Lock LOCK = new ReentrantLock();
    @Override
    public void run() {
        LOCK.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+Thread.currentThread().getName()+"已苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock sleepDontReleaseLock = new SleepDontReleaseLock();
        new Thread(sleepDontReleaseLock).start();
        new Thread(sleepDontReleaseLock).start();

    }
}
