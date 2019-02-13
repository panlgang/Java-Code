package www.test.java;

/**
 * 题目描述：
 * [0,1,2,0,13]
 * 0放在数组的末尾，其它元素放在数组的前面，但相对位置保持不变
 * [1,2,13,0,0]
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 13};
        System.out.print("[");
        moveZeros_3(arr);
        for (int data : arr) {
            System.out.print(data + "，");
        }
        System.out.print("]");
    }

    /**
     * 时间O（n）,空间O(n).
     *
     * @param arr
     */
    public static void moveZeros_1(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Error!");
        }
        int[] help = new int[arr.length];
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                help[j++] = arr[i];
            }
        }
        for (i = j; j < help.length; j++) {
            help[j] = 0;
        }
        for (i = 0; i < arr.length; i++) {
            arr[i] = help[i];
        }
    }

    /**
     * 时间O（n）,空间O(1).
     *
     * @param arr
     */
    public static void moveZeros_2(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Error!");
        }
        int i = 0;
        int k = 0;
        for (i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }
        for (; k < arr.length; k++) {
            arr[k] = 0;
        }
    }

    /**
     * 交换
     *
     * @param arr
     */
    public static void moveZeros_3(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Error!");
        }
        int i = 0;
        int k = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != k) {
                    swap(arr, i, k++);
                } else {
                    k++;
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
