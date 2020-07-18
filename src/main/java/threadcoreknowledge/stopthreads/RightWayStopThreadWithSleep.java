package threadcoreknowledge.stopthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 23:14
 * @description: 带有sleep的中断线程方法
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <=10000) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(5000);
        thread.interrupt();

    }
}
