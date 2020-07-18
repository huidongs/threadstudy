package threadcoreknowledge.startthread;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 13:33
 * @description: 对比start和run两种启动线程的方式
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}
