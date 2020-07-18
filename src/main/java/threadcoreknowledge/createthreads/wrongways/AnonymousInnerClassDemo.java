package threadcoreknowledge.createthreads.wrongways;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/18 11:22
 * @description:
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二个："+Thread.currentThread().getName());
            }
        }).start();
    }
}
