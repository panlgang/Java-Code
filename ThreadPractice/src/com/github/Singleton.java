package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 同步机制，解决懒汉式单例模式线程不安全问题。
 */
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {
    }
    public static Singleton newInstance() throws InterruptedException {
        if(instance == null) {
            Thread.currentThread().sleep(1000);
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;

//        if(instance == null){
//            Thread.currentThread().sleep(1000);
//            instance = new Singleton();
//        }
//        return instance;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton> callable = new Mythread3();
        FutureTask<Singleton> futureTask1 = new FutureTask<>(callable);
        FutureTask<Singleton> futureTask2 = new FutureTask<>(callable);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        Singleton singleton1 = futureTask1.get();
        Singleton singleton2 = futureTask2.get();
        System.out.println(singleton1 == singleton2);
    }
}
class Mythread3 implements Callable<Singleton> {
    @Override
    public Singleton call() throws Exception {
        return Singleton.newInstance();
    }
}