package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther plg
 * @date 2019/5/15 22:04
 */
public class TestFuture implements Callable<String> {
    private int ticket = 20;
    @Override
    public synchronized  String call() throws Exception {
       while(this.ticket > 0){
           System.out.println(Thread.currentThread().getName() + "将" + this.ticket-- + " 张票卖出");
       }
       return "票卖光了 ~~";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       TestFuture test = new TestFuture();
       for(int i = 0; i < 5; i++){
           FutureTask<String> futureTask = new FutureTask<>(test);
           new Thread(futureTask).start();
       }

    }
}
