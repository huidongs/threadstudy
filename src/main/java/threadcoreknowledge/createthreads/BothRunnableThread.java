package threadcoreknowledge.createthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 1:52
 * @description: 同时使用Runnable和Thread两种实现线程的方式
 */
public class BothRunnableThread {
    public static void main(String[] args) {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println("我来自Runnable");
             }
         }){
             @Override
             public void run() {
                 System.out.println("我来自Thread");
             }
         }.start();

    }
}
