package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 19:11
 * @description: 展示sleep的时候不释放synchronized的monitor，等sleep时间到了以后，正常结束才释放锁
 */
public class SleepDontReleaseMonitor implements Runnable{

    public static void main(String[] args) {
        SleepDontReleaseMonitor sleepDontReleaseMonitor = new SleepDontReleaseMonitor();
        Thread thread1 = new Thread(sleepDontReleaseMonitor);
        Thread thread2 = new Thread(sleepDontReleaseMonitor);
        thread1.start();
        thread2.start();
    }
    @Override
    public void run() {
        syn();
    }
    private synchronized void syn(){
        System.out.println("线程"+Thread.currentThread().getName()+"获取了monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"退出了代码块");
    }
}
