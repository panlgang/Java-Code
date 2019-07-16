package www.review.java;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int step = n / 2;
        while (step >= 1) {
            for (int i = step; i < n; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0 && arr[j] > value; j -= step) {
                   arr[j+step] = arr[j];
                }
                arr[j + step] = value;
            }
            step /= 2;
        }
    }


}
