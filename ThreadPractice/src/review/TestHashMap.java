package review;

import java.util.HashMap;

/**
 * @auther plg
 * @date 2019/7/4 9:38
 */
public class TestHashMap {
    public static void main(String[] args) throws InterruptedException {
        HashMap map = new HashMap();
        new Thread(()->{
            for(int i = 0; i < 100; i++){
                map.put(i,i);
            }
        }).start();

        new Thread(()->{
            for(int i = 0; i < 100; i++){
                map.remove(i,i);
            }
        }).start();
        Thread.sleep(10);
        System.out.println(map.size());
    }
}
