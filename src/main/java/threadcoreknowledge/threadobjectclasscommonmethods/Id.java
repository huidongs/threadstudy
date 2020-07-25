package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/22 14:22
 * @description: 从1开始，JVM运行起来后我们自己创建的线程的id早已不是2
 */
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
//        thread.start();
        System.out.println(Thread.currentThread().getId());
        System.out.println(thread.getId());
    }
}
