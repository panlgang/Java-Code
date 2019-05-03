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
        executor.execute(()->sleepSecond(10));  // thread0 直接执行
        executor.execute(()->sleepSecond(10));  // 进入队列此时队列已满，创建新线程执行
        executor.execute(()->sleepSecond(10));  // thread0 执行完继续执行
        // 提交该任务队列已满，直接创建一个新线程，执行刚提交的任务。
        // 已满，代表将这个入队列会超限
        // 提交速度特别特别快
        executor.execute(()->sleepSecond("hello"));
    }
    private static void sleepSecond(String str)  {
        System.out.println(Thread.currentThread().getName() + str);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
