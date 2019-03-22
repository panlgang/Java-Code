/**
 * @auther plg
 * @date 2019/3/22 17:21
 */
public class TestHeap {
    public static void main(String[] args) {
        BigHeap bigHeap = new BigHeap(4);
        bigHeap.insert(1);
        bigHeap.insert(3);
        bigHeap.insert(10);
        bigHeap.insert(4);
        bigHeap.insert(7);
        int[] arr = bigHeap.toArray();
        System.out.println(bigHeap.exteraMax());
        System.out.println(bigHeap.exteraMax());
    }
}
