package threadcoreknowledge.stopthreads.volatiledemo;

import javax.annotation.PreDestroy;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/19 22:16
 * @description: 演示用volatile的局限part2:
 * 陷入阻塞时，volatile是无法线程的，
 * 此例中，生产者的生成速度很快，消费者消费速度慢，
 * 所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(16);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        producerThread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take()+"被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        producer.canceled=true;
    }
}
class Producer implements Runnable{
    public volatile boolean canceled = false;
    BlockingQueue storage;
    public Producer(BlockingQueue storage){
        this.storage=storage;
    }
    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !canceled) {
                if (num % 100 == 0) {
                    storage.put(num);
                    System.out.println(num+"是100的倍数,被放到仓库中了");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者停止运行");
        }
    }
}
class Consumer{
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }
    public boolean needMoreNums(){
        if (Math.random()>0.95){
            return false;
        }
        return true;
    }
}

