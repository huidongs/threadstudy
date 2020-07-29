package background;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/25 19:27
 * @description: 第一种：运行结果出错。演示计数不准确，找出具体的位置
 */
public class MultiThreadsError implements Runnable {
    int index = 0;
    final boolean[] marked = new boolean[1000000];
    static MultiThreadsError instance = new MultiThreadsError();
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();
    static volatile CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上的结果是：" + instance.index);
        System.out.println("真正运行的次数：" + realIndex.get());
        System.out.println("错误次数" + wrongCount.get());

    }

    @Override
    public void run() {
        marked[0] = true;
        for (int i = 0; i < 50000; i++) {
            try {
                cyclicBarrier2.reset();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;//这里本因该每次执行了两下，发生冲突后少执行一次;
            try {
                cyclicBarrier.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance) {
                if (marked[index]&&marked[index-1]) {
                    System.out.println("出现错误" + index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
