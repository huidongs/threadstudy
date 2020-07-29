package background;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/29 12:22
 * @description: 用工厂模式修复刚才的初始化问题
 */
public class MultiThreadsError7 {
    int count;
    private EventListener listener;
    private MultiThreadsError7(MySource source){
        listener = new EventListener() {
            @Override
            public void onEvent(MultiThreadsError5.Event e) {
                System.out.println("\n我得到的数字是"+count);
            }
        };

        for (int i=0;i<10000;i++){
            System.out.print(i);
        }
        count=100;
    }
    public static MultiThreadsError7 getInstance(MySource source){
        MultiThreadsError7 safeListener = new MultiThreadsError7(source);
        source.registerListener((MultiThreadsError5.EventListener) safeListener);
        return safeListener;
    }

    public static void main(String[] args) {
        MultiThreadsError5.MySource mySource = new MultiThreadsError5.MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mySource.eventCome(new MultiThreadsError5.Event() {
                });
            }
        }).start();
        MultiThreadsError5 multiThreadsError5 = new MultiThreadsError5(mySource);
    }

    static class MySource{
        private MultiThreadsError5.EventListener listener;
        void registerListener(MultiThreadsError5.EventListener eventListener){
            this.listener = eventListener;
        }
        void eventCome(MultiThreadsError5.Event e){
            if (listener!=null){
                listener.onEvent(e);
            }else{
                System.out.println("还未初始化完毕");
            }

        }
    }
    interface EventListener{
        void onEvent(MultiThreadsError5.Event e);
    }
    interface Event{

    }
}
