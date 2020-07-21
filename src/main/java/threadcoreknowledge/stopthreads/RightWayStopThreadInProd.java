package threadcoreknowledge.stopthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/19 15:00
 * @description: 最佳实践：catch了InterruptedExcetion之后的优先选择:在方法签名中抛出异常
 */
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }
    //如果是提供给别人的，最好抛出异常，不要捕获异常
    public void throwInMethod() throws InterruptedException {
            Thread.sleep(1000);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        thread.sleep(5000);
        thread.interrupt();
    }
}
