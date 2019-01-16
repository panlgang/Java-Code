package www.test.java;

/**
 * 00000
 * 00001
 * 00010
 * 00011
 * 00100
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int m = 0; m <= 1; m++) {
                    for (int n = 0; n <= 1; n++) {
                        for (int k = 0; k <= 1; k++) {
                            System.out.printf("%d%d%d%d%d\n", i, j, m, n, k);
                        }
                    }
                }
            }
        }
        System.out.println("******************分隔符************************");
        fun();


    }

    public static void fun() {    //10进制转2进制
        for (int i = 0; i < 32; i++) {
            int count = 5;
            int[] arr = new int[count];
            int num = i;
            while (count-- > 0) {
                arr[count] = num % 2;
                num /= 2;
            }
            for (int data : arr) {
                System.out.print(data);
            }
            System.out.println();

        }
    }
}

/**
 * 00000
 * 00001
 * 00010
 * 00011
 *
 *
 */
