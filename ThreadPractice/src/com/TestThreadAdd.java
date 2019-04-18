package com;

/**
 * 主内存，对象内存
 * @auther plg
 * @date 2019/4/18 17:44
 */
class MyThread extends Thread{
    public static int num = 0;
    @Override
    public void run() {
        for(int i = 0; i < 20000; i++){
            num++;
        }
    }
    public int getNum(){
        return this.num;
    }
}
public class TestThreadAdd {
    public static void main(String[] args) {
       MyThread mt1 = new MyThread();
       MyThread mt2 = new MyThread();
       mt1.start();
       mt2.start();
       try{
           mt1.join();
           mt2.join();
      }catch (InterruptedException e){
           e.printStackTrace();
       }
        System.out.println(MyThread.num);
    }
}
