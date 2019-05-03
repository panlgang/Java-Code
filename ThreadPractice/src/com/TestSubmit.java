package com;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther plg
 * @date 2019/5/3 12:20
 */
public class TestSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 2000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1),
                new ThreadFactory() {
                    private final AtomicInteger id = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("Thread" + id.incrementAndGet());
                        return t;
                    }
                }, new ThreadPoolExecutor.AbortPolicy());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(threadPoolExecutor.getQueue().size());
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
//        for(int i = 0; i < 8; i++){
//            threadPoolExecutor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(threadPoolExecutor.getQueue().size());
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        threadPoolExecutor.shutdown();
       // 有返回值的
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(500);
                return Thread.currentThread().getName();
            }
        };
        for (int i = 0; i < 10; i++) {
            Future<String> future = threadPoolExecutor.submit(callable);
            // 会阻塞其它线程，只有当当前线程执行完毕，且返回值取得之后才会执行其它线程
            //System.out.println(future.get());
            list.add(future);
        }
        for (Future<String> future : list) {
            System.out.println(future.get());
        }

        threadPoolExecutor.shutdown();
        Thread.sleep(1000);
        System.out.println(threadPoolExecutor.isTerminated());
    }
}
