package com.github;

/**
 * 线程退出的方法
 * @auther plg
 * @date 2019/4/14 18:47
 */
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
       ThreadA threadA = new ThreadA();
       Thread thread = new Thread(threadA);
       thread.start();
       Thread.currentThread().sleep(10);
       thread.interrupt();
       //Thread.currentThread().stop();
    }
}
class ThreadA implements Runnable{

    private Boolean flag = true;
    public void setFlag(Boolean flag){
        this.flag = flag;
    }
    @Override
    public void run(){
        int i = 0;
        while(flag){
            try {
                Thread.sleep(10);
                System.out.println(++i);
                boolean state = Thread.currentThread().isInterrupted(); // 判断有没有收到中断信号
                System.out.println(state);
                if(state){  // 非阻塞情况下
                    System.out.println("非阻塞情况线程状态:" + state);
                    break;
                }
            } catch (InterruptedException e) {  // 阻塞情况下调用interrupte()会抛该异常
                e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted());
                // 退出阻塞状态，且中断标志位被自动清除，设置为false，即恢复之前的状态
                return;
            }

        }
    }

}
/**  线程终止的方法
 *   1.标记位，信号量，停止线程
 *   2.Thread.stop()线程立即退出，stop后的语句不会再执行，可能发生残废数据的问题
 *   3.interrupt()方法，给线程发一个信号
 *        --- 线程若是阻塞状态，接收到信号则退出阻塞状态，（wait,join,sleep引起的）抛出异常，中断位恢复为false，即没中断
 *        --- 非阻塞状态：中断标志位设置为true，由个人决定是否停止该线程
 *    具体哪个引起线程停止是一个概率问题，需要判断线程正常运行的时间多，还是阻塞的时间多
 *    哪个多，哪个自然更容易引起线程停止。
 */
