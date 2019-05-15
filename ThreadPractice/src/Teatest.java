package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * A 线程： 洗水壶 -- 》 烧水
 * B 线程： 洗水杯  --》 洗茶壶 --》 拿茶叶
 * 最终 泡茶
 *
 *
 * @auther plg
 * @date 2019/5/15 22:24
 */
public class Teatest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Task1 task1 = new Task1();
        FutureTask<String > futureTask1 = new FutureTask<>(task1);
        Task2 task2 = new Task2(futureTask1);
        FutureTask<String > futureTask2 = new FutureTask<>(task2);
         new Thread(futureTask2).start();
        Thread.sleep(2000);
        new Thread(futureTask1).start();
        System.out.println(futureTask2.get());

    }
}
// A 线程
class Task2 implements Callable<String>{
    private FutureTask<String> futureTask;

    public Task2(FutureTask<String> futureTask) {
        this.futureTask = futureTask;
    }

    @Override
    public String call() throws Exception {
        System.out.println("T1: 洗水壶");
        Thread.sleep(2000);
        System.out.println("T1: 烧水");
        Thread.sleep(15000);
        System.out.println("等待茶具");
        System.out.println(futureTask.get());
        return "一壶好茶";
    }
}
// B 线程
class Task1 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("T2: 洗水杯");
        Thread.sleep(1000);
        System.out.println("T2: 洗茶壶");
        Thread.sleep(2000);
        System.out.println("T2: 取茶叶");
        Thread.sleep(1000);
        return "茶叶，茶壶，茶杯就绪。。";
    }
}
