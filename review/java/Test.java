package www.review.java;

public class Test {
    public static void main(String[] args) {
        int[] arr = generateArr(10,100);
        for(int data : arr){
            System.out.print(data + "、");
        }
        System.out.println();
       // BubbleSort.bubbleSort(arr);
        //SelectionSort.selectionSort(arr);
        //InsertionSort.insertionSort_4(arr);
        //MergeSort.mergeSort(arr);
        //MergeSort.mergeSOrtBU(arr);
        //QuickSort.quickSort(arr);
        //HeapSort1.heapSort(arr);
        //HeapSort.headSort(arr);
        ShellSort.shellSort(arr);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static int[] generateArr(int size,int value){
        int[] arr = new int[(int)((size+1)*Math.random())]; // 长度[1..size]
        for(int i = 0; i < arr.length;i++){
            arr[i] = (int)((value + 1) * Math.random());  //   大小[1..value]
        }
        return arr;
    }
}
