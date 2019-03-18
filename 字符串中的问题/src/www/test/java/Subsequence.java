package www.test.java;

public class Subsequence {
    public static void subsequence(char[] arr,int i,String res){
        if(i == arr.length){
            System.out.println(res);
            return;
        }
        subsequence(arr,i+1,res + arr[i]);
        subsequence(arr,i+1,res);
    }

    public static void main(String[] args) {
        String str = "abc";
        subsequence(str.toCharArray(),0,"");
    }
}
