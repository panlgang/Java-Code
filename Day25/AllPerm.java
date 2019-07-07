package Day25;

/**
 * 剑指offer：28  字符串的全排列
 * @auther plg
 * @date 2019/7/5 22:36
 */
public class AllPerm {
    public static void main(String[] args) {
        allPerm("abc");
    }
    public static void allPerm(String str){
        if(str == null || str.length()== 0){
            return;
        }
        allPerm(str.toCharArray(),0,str.length() - 1);
    }

    private static void allPerm(char[] chars, int l, int r) {
        if(l == r){
            String str = "";
            for(int i = 0;i <= r; i++){
               str += chars[i];
            }
            System.out.println(str);
        }

        for(int i = l; i <= r; i++){
            swap(chars,l,i);
            allPerm(chars,l+1,r);
            swap(chars,l,i);
        }
    }
    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
