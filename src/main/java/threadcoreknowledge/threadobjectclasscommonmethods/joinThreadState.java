package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 21:37
 * @description: 先join再mainThread.getState()，通过debugger看线程join前后状态的对比
 */
public class joinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThead = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(mainThead.getState());
                    System.out.println("Thread-0运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        thread.join();
        System.out.println("子线程运行完毕");
    }
}
