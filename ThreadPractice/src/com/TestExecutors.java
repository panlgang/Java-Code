package com;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @auther plg
 * @date 2019/5/3 14:40
 */
public class TestExecutors {
    public static void main(String[] args) {
        // 固定大小的线程池
//        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
////        for(int i = 0; i < 10; i++){
////            executorService1.execute(()->{
////                try {
////                    Thread.sleep(1000);
////                    System.out.println("hehe");
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            });
////        }
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        for(int i = 0; i < 200; i++){
            executorService2.execute(()->{
                try {
                    Thread.sleep(10000);
                    System.out.println("hehe");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 100; i++){
            executorService3.execute(()-> System.out.println("haha"));
        }
    }
}
