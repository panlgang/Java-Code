package Future;

/**
 * @auther plg
 * @date 2019/5/16 22:47
 */
public class TestVolatile {
    private static volatile Integer num = 10;
    private static Object object = new Object();
    public static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "=="  + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=="  + num);
            for(int i = 0; i < 10; i++){
                num++;
                if(i == 5){
                    try {
                        System.out.println("=====" + num);
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "=="  + num);
        }
    }
    public static class B implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "=="  + num);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=="  + num);
                for(int i = 0; i < 10; i++){
                    num++;
                }
                System.out.println(Thread.currentThread().getName() + "=="  + num);
            }
        }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        new Thread(a).start();
        new Thread(b).start();
    }
}

