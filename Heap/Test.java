package Heap;

/**
 * @auther plg
 * @date 2019/6/6 22:30
 */
public class Test {
    public static void main(String[] args) {
        THeap<Integer> heap = new THeap<>();
        int[] arr = generateArr(1000000,100000);
        test(arr,heap);
    }
    public static int[] generateArr(int size,int max){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)(Math.random() + 1) * max;
        }
        return arr;
    }
    public static void test(int[] arr,THeap<Integer> heap){
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }
        int prev = Integer.MAX_VALUE;
        while(!heap.isEmpty()){
            int cur = heap.extractMax();
            if(prev < cur){
                System.out.println("Facking facked !!!");
            }
            prev = cur;

        }
        System.out.println("Nice !!!");
    }
}
