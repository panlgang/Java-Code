package review;

import java.util.concurrent.TimeUnit;

/**
 * @auther plg
 * @date 2019/7/4 11:26
 */
public class TestVolatile extends Thread {
    volatile boolean  flag = false;
    @Override
    public void run() {
        while(!flag){
            System.out.println("do songthing");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.start();
        new Thread(() -> {
            testVolatile.flag = true;
        }).start();
    }
}
