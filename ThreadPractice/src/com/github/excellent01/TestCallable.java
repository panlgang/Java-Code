package com.github.excellent01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther plg
 * @date 2019/4/14 18:34
 */
public class TestCallable {
    public static void main(String[] args) {
        Callable callable = new MyCallable();
        FutureTask fu = new FutureTask(callable);
        new Thread(fu).start();
        try {
            int num = (int) fu.get();  // get方法会阻塞主线程，直至等到run方法执行完毕，将返回值返回.
            System.out.println(num);
            System.out.println("heihei");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0; i < 100000; i++){
            sum += i;
        }
        System.out.println("hehe");
        return sum;
    }
}
