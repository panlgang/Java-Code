package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @auther plg
 * @date 2019/5/15 22:18
 */
public class TestFuture2 implements Callable<String> {
    private int ticket = 20;
    @Override
    public synchronized  String call() throws Exception {
        while(this.ticket > 0){
            System.out.println(Thread.currentThread().getName() + "将" + this.ticket-- + " 张票卖出");
        }
        return "票卖光了 ~~";
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        TestFuture2 test = new TestFuture2();
        for(int i = 0; i < 5; i++){
            FutureTask<String> futureTask = new FutureTask<>(test);
            service.submit(futureTask);
        }
    }
}
