package threadcoreknowledge.stopthreads;

/**
 * @program: threadstudy
 * @auther: HuiDong
 * @date: 2020/7/19 16:17
 * @description: run无法抛出checked Exception，只能用try/catch
 */
public class RunThrowException {
    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
