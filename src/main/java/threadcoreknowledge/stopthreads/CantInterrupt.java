package threadcoreknowledge.stopthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/19 13:41
 * @description:
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的整数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(5000);
        thread.interrupt();
    }
}