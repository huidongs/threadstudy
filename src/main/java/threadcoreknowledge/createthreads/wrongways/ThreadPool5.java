package threadcoreknowledge.createthreads.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 10:27
 * @description: 线程池创建线程的方法
 */
public class ThreadPool5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0 ; i<1000; i++){
            executorService.submit(new Task(){});

        }
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程为："+ Thread.currentThread().getName());

    }
}