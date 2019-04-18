package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/4/14 12:33
 */
public class TestThread {
    public static void main(String[] args) {

    }
}
// 自定义类继承Thread，覆写run方法，写真正的业务逻辑
class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName() + "===" + i);
        }
    }
}
/**
 *   1. 单继承局限
 *   2. 难以实现资源共享问题（属性前加static使得属性变成类属性，多个对象共用）
 *   3. 创建调度和业务逻辑耦合，后期难以维护
 */
