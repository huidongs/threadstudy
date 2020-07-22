package threadcoreknowledge.threadobjectclasscommonmethods;

import com.sun.corba.se.impl.encoding.CDROutputObject;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/22 8:50
 * @description: 通过join原理，分析出join的代替写法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入run");
                    Thread.sleep(5000);
                    System.out.println("Thread1 finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        System.out.println("开始等待子线程运行完毕");
      //  thread1.join();
        synchronized (thread1){
            System.out.println(Thread.currentThread().getName()+"拿到锁了");
            thread1.wait();//主线程开始等待
            System.out.println(Thread.currentThread().getName()+"执了wait");
        }
        System.out.println("所有子线程执行完毕");
    }
}
