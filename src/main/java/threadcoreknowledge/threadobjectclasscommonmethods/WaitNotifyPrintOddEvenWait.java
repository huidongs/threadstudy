package threadcoreknowledge.threadobjectclasscommonmethods;

import jdk.management.resource.internal.inst.ThreadRMHooks;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 17:19
 * @description: 两个线程交替打印0-100的奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEvenWait {
    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己就休眠
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TurningRunning());
        Thread thread2 = new Thread(new TurningRunning());
        thread1.start();
        thread2.start();
    }

    static class TurningRunning implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("线程" + Thread.currentThread().getName() + "打印：" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
