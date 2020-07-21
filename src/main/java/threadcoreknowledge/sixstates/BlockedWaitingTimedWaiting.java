package threadcoreknowledge.sixstates;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/20 14:26
 * @description: 展示Blocked,Waiting,TimedWaiting
 */
public class BlockedWaitingTimedWaiting implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread.sleep(10);
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(50);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        Thread.sleep(1200);
        System.out.println(thread1.getState());
    }
    @Override
    public void run() {
        syn();
    }
    private synchronized void syn(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
