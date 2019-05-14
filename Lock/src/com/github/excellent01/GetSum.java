package com.github.excellent01;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 多线程对数组求和
 * @auther plg
 * @date 2019/5/14 17:07
 */
public class GetSum implements Callable<Integer> {
    private int start = 0;
    private int end = 0;
    // 数组共享，需加static修饰
    private static int[] arr = null;
    static {
        arr = genergte(10000,1000000);
    }
    public GetSum(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = start; i < end; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static int getSum(){
        long start = System.currentTimeMillis();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("遍历求和花费时间：" + (end - start) + "ms");
        return sum;
    }
    public static void isRight(int sum){
        System.out.println("线程所求： " + sum  + "  遍历所求： "  + getSum() + "  结果： "  + (sum == getSum() ? "Nice" : "Error"));
    }

    // for test  随机生成大小为size，[0 , max]的数组
    public static int[] genergte(int max,int size){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)((Math.random()) * (max + 1));
        }
        return arr;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入线程数量：");
        int threadCount = 0;
        threadCount = in.nextInt();
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        // 对数组进行分组
        int subArrSize = (arr.length / threadCount) + 1;
        List<Future<Integer>> list = new ArrayList<>();
        int sum = 0;
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i += subArrSize){
            int end = i + subArrSize;
            end = end >= arr.length ? arr.length : end;
            int num = end;
            list.add(executorService.submit(new GetSum(i,end)));
        }
        // 汇总
        for(Future<Integer> future : list){
            sum += future.get();
        }
        long end = System.currentTimeMillis();
        System.out.println("多线程求和花费时间：" + (end - start) + "ms");
        //判断结果
        isRight(sum);


    }
}
