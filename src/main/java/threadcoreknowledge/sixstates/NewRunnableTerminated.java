package threadcoreknowledge.sixstates;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/20 14:10
 * @description: 展示线程的New，Runnable，Terminated状态，即使是正在运行也是Runnable状态，而不是running
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<1000;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
//        try {
//            thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
