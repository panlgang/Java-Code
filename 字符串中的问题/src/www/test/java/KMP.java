package www.test.java;

/**
 * KMP算法
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "abcabcdabc";
        String str2 = "abcd";
        System.out.println(getIndexOf(str1,str2));

    }
    public static int getIndexOf(String str1,String str2){
        if(str1 == null || str2 == null || str1.length() < str2.length()){
            return -1;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[] next = getNextArray(arr2);
        int i1 = 0;
        int i2 = 0;
        while(i1 < arr1.length && i2 < arr2.length){
            if(arr1[i1] == arr2[i2]){
                i1++;
                i2++;
            }else{
                if(next[i2] == -1){
                    i1++;
                }else{
                    i2 = next[i2];
                }
            }
        }
        return i2 == arr2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] arr){
        if(arr.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn= 0;
        while(i < next.length){
            if(arr[i - 1] == arr[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
