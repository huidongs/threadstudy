package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/20 21:22
 * @description: 证明wait指释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadA got resourceA lock");
                    synchronized (resourceB){
                        System.out.println("ThreadA got resourceB lock");
                        try {
                            resourceA.wait();
                            System.out.println("ThreadA releases resourceA lock");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (resourceA){
                   System.out.println("ThreadB got resourceA lock");
                   synchronized (resourceB){
                       System.out.println("ThreadB got resourceB lock");
                   }
               }
           }
       }).start();
    }
}
