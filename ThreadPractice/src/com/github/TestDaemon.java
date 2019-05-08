/**
 * @auther plg
 * @date 2019/4/25 21:06
 */
public class TestDaemon implements Runnable {
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在执行.....");
        }
    }

    public static void main(String[] args) {
        System.out.println("=====主线程开始执行=========");
        TestDaemon test = new TestDaemon();
        Thread thread = new Thread(test);
        thread.setDaemon(true);
        thread.start();
        System.out.println("=====主线程结束执行=========");
    }
}



    //    @Override
//    public void run() {
//        while(true){
//            System.out.println("我是守护线程！！！");
//        }
//    }


