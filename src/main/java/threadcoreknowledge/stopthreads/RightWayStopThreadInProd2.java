package threadcoreknowledge.stopthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/19 17:11
 * @description: 最佳实力2：在catch子语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，以便于在后续的执行中，
 * 依然能够检查到刚才发生了中断，回到刚才RightWayStopThreadInPord补上中断，让他跳出
 */
public class RightWayStopThreadInProd2 implements Runnable{
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted，程序运行结束");
                break;
            }
            reInterrupt();
        }
    }
    //有第二种方法就是捕获，但是需要在catch中给出interrupt，否则上面将无法获得isInterrupted()
    private void reInterrupt(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
    }
}
