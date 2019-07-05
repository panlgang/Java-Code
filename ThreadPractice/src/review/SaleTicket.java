package review;

import java.util.concurrent.TimeUnit;

/**
 * @auther plg
 * @date 2019/7/4 9:17
 */
public class SaleTicket implements Runnable {
    private  int max = 10;
    @Override
    public void run() {
        int i = 1;
        while(max > 0){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "将" + max-- + "号票卖出");
        }
    }

    public static void main(String[] args) {
        SaleTicket sale = new SaleTicket();
        new Thread(sale,"一号窗口").start();
        new Thread(sale,"三号窗口").start();
        new Thread(sale,"二号窗口").start();
    }
}
