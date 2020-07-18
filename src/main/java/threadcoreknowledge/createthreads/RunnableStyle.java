package threadcoreknowledge.createthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 1:31
 * @description: 用Runnable方式创建线程
 */
public class RunnableStyle implements Runnable{
    @Override
    public void run() {
        System.out.println("用Runnable方式实现了线程,当前线程是："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
    //    Thread thread = new Thread(new RunnableStyle());
    //    thread.start();
    }
}
