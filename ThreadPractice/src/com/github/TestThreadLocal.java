/**
 * @auther plg
 * @date 2019/4/28 16:53
 */
public class TestThreadLocal {
    private static String str1;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
       str1 = "hello";
       threadLocal.set("main");
        System.out.println(str1);
        System.out.println(threadLocal.get());
        int i = 0;
       while(true){
           i++;
           new Thread(()->{
               str1 = "Thread";
               threadLocal.set("Thread");
               System.out.println(str1);
               System.out.println(threadLocal.get());
               while(true){}
           }).start();
           if(i > 100){
               break;
           }
       }
       Thread.sleep(1000);
        System.out.println(str1);  // 被改了。
        System.out.println(threadLocal.get()); // 没被改
    }
}
