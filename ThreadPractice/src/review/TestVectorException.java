package review;

import java.util.Vector;

/**
 * 线程安全的类不一定是线程安全的
 * @auther plg
 * @date 2019/7/5 17:21
 */
public class TestVectorException {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        for(int i = 0; i < 5; i++){
            vector.add(i);
        }
        while(true){
            new Thread(()->{
                int lastIndex = vector.size() - 1;
                vector.get(lastIndex);
            }).start();

            new Thread(()->{
                int lastIndex = vector.size() - 1;
                vector.remove(lastIndex);
            }).start();
        }
    }
}
