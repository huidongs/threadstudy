package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 9:17
 * @description: 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 */
public class WaitNotifyPrintOddEvenSyn {
    private static final Object lock = new Object();
    public static int count = 0;
    //建两个线程
    //一个处理奇数，第二个只处理偶数
    //用synchronized来通信
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100){
                    synchronized (lock){
                        if ((count & 1)==0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<100){
                    synchronized (lock){
                        if ((count & 1)==1){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        });
        thread2.start();
    }
}
