package threadcoreknowledge.uncaughtexception;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/23 10:44
 * @description:   不加try catch抛出4个异常，都带线程名字
 *                 加了try catch，期望捕获到第一个线程的异常，线程234都不应该运行，希望看到打印出Caught Exception
 *                 执行时发现，根本没有Caught Exception，线程234依然运行并且抛出异常
 *               说明线程的异常不能用传统方法捕获:
 *                 原因：try catch中是主线程中执行的
 */
public class CantCatchDirectly implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        try{
        new Thread(new CantCatchDirectly(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new CantCatchDirectly(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new CantCatchDirectly(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new CantCatchDirectly(), "MyThread-4").start();
        Thread.sleep(300);
    }catch (RuntimeException e){
            System.out.println("Caught Exception");
        }
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
