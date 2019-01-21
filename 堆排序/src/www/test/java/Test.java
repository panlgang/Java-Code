package www.test.java;
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] { 1,5,2,3,7,9,0,8};
        heapSort(arr);
        for(int data : arr){
            System.out.print(data);
        }
    }
    public static void heapSort(int[] arr){    //堆排序
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);        //   形成一个大根堆
        }
        int size = arr.length;
        while(size > 0){
            swap(arr,0,--size);
            heapify(arr,0, size); //这个0 很灵性
           // swap(arr,0,--size);
        }
    }
    public static void heapInsert(int[] arr,int index){   //形成一个大根堆
        while(arr[index] > arr[(index - 1) / 2 ]){       //当前位置比父节点大
            swap(arr,index,(index - 1) / 2);          //交换
            index = (index - 1) / 2;            //跟父节点位置交换，继续while循环
        }
    }
    public static void heapify(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            //左右节点值最大的下标
            int largest = (left + 1) < size &&arr[left] < arr[left + 1] ? left + 1 : left;
            //左右头三个节点中最大的下标
            largest = arr[largest] > arr[index] ? largest : index;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = left * 2 + 1;

        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
