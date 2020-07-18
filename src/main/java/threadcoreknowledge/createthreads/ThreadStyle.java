package threadcoreknowledge.createthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 1:45
 * @description: 用Thread方式实现线程
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("用Thread类方式实现线程，当前线程是："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadStyle threadStyle = new ThreadStyle();
        threadStyle.start();
    }
}
