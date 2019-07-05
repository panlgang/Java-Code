package review;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @auther plg
 * @date 2019/7/5 17:34
 */
public class TestCME {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("C++");
        // modCount = 4;

//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("world")){
                list.remove(str);
               // iterator.remove();
            }
            System.out.println(str);
        }
        System.out.println(list.size());
    }
}
