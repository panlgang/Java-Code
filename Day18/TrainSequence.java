package Day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @auther plg
 * @date 2019/6/7 16:17
 */
public class TrainSequence {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String str = "";
        while(in.hasNext()){
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = in.nextInt();
                str += arr[i];
            }
            process(arr,0,arr.length - 1,list);
            for(int i = 0; i < list.size(); i++){
                String ret = "";
                if(isLegalOrder(str,list.get(i))){
                    char[] help = list.get(i).toCharArray();
                    for(char ch : help){
                        ret += (ch + " ");
                    }
                    System.out.println(ret.substring(0,ret.length() - 1));
                }
            }
        }
    }
    public static void process(int[] arr, int start, int end, List<String> list){
        String str = "";
        if(start == end){
            for(int i = 0; i <= end; i++){
                str += arr[i];
            }
            list.add(str);
        }
        for(int i = start; i <= end; i++){
            swap(arr,start,i);
            process(arr,start+1,end,list);
            swap(arr,start,i);
        }
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isLegalOrder(String str,String str2){
        char[] arr1 = str.toCharArray();
        char[] arr2 = str2.toCharArray();
        Stack<Character> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < arr1.length; i++){
            stack.push(arr1[i]);
            while(!stack.isEmpty() && stack.peek() == arr2[j] && j < arr2.length){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
