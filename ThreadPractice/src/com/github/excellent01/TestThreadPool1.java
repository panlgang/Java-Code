import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther plg
 * @date 2019/5/2 23:24
 */
public class TestThreadPool1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = buildThreadPoolInstance();
        executor(executor);
        System.out.println(executor.getQueue().size());
    }
    private static ThreadPoolExecutor buildThreadPoolInstance(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,30, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1),r->{
            return new Thread(r);
        });
        return threadPoolExecutor;
    }
    private static void sleepSecond(long second){
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void executor(ThreadPoolExecutor executor){
        executor.execute(()->sleepSecond(1));  // thread0 直接执行
        executor.execute(()->sleepSecond(1));  // 进入队列此时队列已满，创建新线程执行
        executor.execute(()->sleepSecond(1));  // thread0 执行完继续执行
        sleepSecond(10);
        executor.execute(()->sleepSecond(10));


    }
}
