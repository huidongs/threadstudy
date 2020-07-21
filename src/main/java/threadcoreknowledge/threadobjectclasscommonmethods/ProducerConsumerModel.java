package threadcoreknowledge.threadobjectclasscommonmethods;
import java.util.Date;
import java.util.LinkedList;
/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/21 8:42
 * @description: 不使用阻塞队列实现生产者消费者模式
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage(10);
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
class Producer implements Runnable{
    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0 ;i<100;i++){
            eventStorage.put();
        }
    }

}
class Consumer implements Runnable{
    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0 ;i<100;i++){
                eventStorage.take();
        }
    }

}
class EventStorage{
    private int maxsize;
    private LinkedList<Date> storage=new LinkedList<>();

    public EventStorage(int maxsize) {
        this.maxsize = 10;
       //this.storage = new LinkedList<>();
    }
    public synchronized void put(){
        while (storage.size()==10){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了"+storage.size()+"个产品");
        notify();
    }
    public synchronized void take(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了"+storage.poll()+"现在仓库还剩下"+storage.size());
        notify();
    }
}
