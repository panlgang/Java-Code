package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther plg
 * @date 2019/6/6 22:30
 */
public class Test {
    public static void main(String[] args) {
        SmallHeap<Integer> heap = new SmallHeap<>();
        int[] arr = generateArr(20,100);
        List<Integer> ret = smallK(heap,arr,10);
        System.out.println(ret);
       for(int i = 0; i < ret.size(); i++){
           System.out.print(ret.get(i) + " ");
       }
        Arrays.sort(arr);
        for(int data : arr){
            System.out.print(data + " ");
        }
    }
    public static int[] generateArr(int size,int max){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)((Math.random() * max));
        }
        return arr;
    }
    public static void test(int[] arr,SmallHeap<Integer> heap){
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }
        System.out.println(heap.getSize());
        System.out.println("===================");
        int prev = Integer.MIN_VALUE;
        while(!heap.isEmpty()){
            int cur = heap.extraMin();
            if(prev > cur){
                System.out.println("Facking facked !!!");
                return;
            }
            prev = cur;

        }
        System.out.println("Nice !!!");
    }
    // 找出一个数组中前K个小的数
    public static List<Integer> smallK(SmallHeap<Integer> smallHeap,int[] arr,int k){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            smallHeap.add(arr[i]);
        }
        for(int i = k;i < arr.length; i ++){
            if(arr[k] < smallHeap.getMin()){
                smallHeap.extraMin();
                smallHeap.add(arr[i]);
            }
        }
        while(!smallHeap.isEmpty()){
            list.add(smallHeap.extraMin());
        }
        return list;
    }
}
