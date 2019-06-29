package Day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/31 14:45
 */
public class Solution {
    public int[] multiply(Integer[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] B = new int[]{A.length};
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;

    }
}
