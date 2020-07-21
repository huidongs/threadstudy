package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/20 20:25
 * @description: 3三个线程，线程1和线程2首先被阻塞，线程3唤醒它们，notify，notifyAll
 */
public class WaitNotifyAll implements Runnable{
    private static final Object resourceA = new Object();

    public static void main(String[] args) {
        Runnable r = new WaitNotifyAll();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        threadA.start();
        threadB.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    resourceA.notifyAll();
//                    resourceA.notify();
                    System.out.println(Thread.currentThread().getName()+"ThreadC notified");
                }
            }
        }).start();

    }
    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName()+"got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName()+"wait to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"is waiting to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
