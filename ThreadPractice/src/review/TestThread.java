package review;

/**
 * @auther plg
 * @date 2019/6/28 14:52
 */
public class TestThread {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        System.out.println(thread.getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(thread.getPriority());
        System.out.println(thread.currentThread().getPriority());
    }
}
