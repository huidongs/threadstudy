package threadcoreknowledge.stopthreads.volatiledemo;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/19 22:03
 * @description: 演示volatile的局限：Part1 看似可行
 */
public class WrongWayVolatile implements Runnable {
    private volatile boolean canceled = false;
    @Override
    public void run() {
        int num = 0;
        try {
            while (num < 10000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num+"是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile wrongWayVolatile = new WrongWayVolatile();
        Thread thread = new Thread(wrongWayVolatile);
        thread.start();
        Thread.sleep(5000);
        wrongWayVolatile.canceled=true;
    }
}

