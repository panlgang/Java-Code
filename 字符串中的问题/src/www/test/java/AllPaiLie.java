package www.test.java;

/**
 * 打印字符串的全排列
 * 待理解
 */
public class AllPaiLie {
    public static void main(String[] args) {
        allPaiLie("abc");
    }

    public static void allPaiLie(String str){
        if(str == null){
            return;
        }
        allPaiLie(str.toCharArray(),0,str.length() - 1);
    }
    private static void allPaiLie(char[] arr,int start,int end){
        if(start == end){
            for(int i = 0; i <= end; i++){
                System.out.print(arr[i]);
            }
            System.out.println();

            return;
        }
        for(int i = start; i <= end; i++){
            swap(arr,start,i);
            allPaiLie(arr,start+1,end);
            swap(arr,start,i);
        }
    }
    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
