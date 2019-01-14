package www.test.java;

/**
 *    1
 *   1 1
 *  1 2 1
 * 1 3 3 1
 */
public class Test {
    public static void main(String[] args) {
        print();
    }
    public static void print() {
        int i = 0;
        int j = 0;
        int[][] arr = new int[10][10];
        for(i = 0; i < 10; i++){
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        for(i = 2; i < 10; i++){
            for(j = 1; j < i; j++){
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
       for(int m = 0; m < 10; m++){
            for(int n = 0; n < 10 - m; n++){
                System.out.print(" ");
            }
            for(int k = 0; k <= m; k++){
                System.out.print(arr[m][k] + " ");
            }
           System.out.println();
        }


    }

}
