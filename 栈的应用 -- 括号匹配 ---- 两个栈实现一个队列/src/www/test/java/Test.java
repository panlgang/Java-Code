package www.test.java;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackList st = new StackList();
        String str = input.nextLine();
        match(str,st);
    }
    public static void match(String str,StackList st) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<') {
                st.pushStack(arr[i]);
            } else if (arr[i] == ')' || arr[i] == ']' || arr[i] == '}' || arr[i] == '>') {
                StackList.Node ret = st.popStack(); //提防ret的值为空
               if(ret == null || (ismatch((char)(ret.data),arr[i])) == false){
                    System.out.println("Fucking Fucked!");
                        return;
                }
            }
        }
        if(st.head.size == 0){
            System.out.println("Nice!");
        }else{
            System.out.println("Fucking Fucked!");
        }
    }
        public static boolean ismatch(char ch1,char ch2){
            if ((ch1 == '{' && ch2 == '}') ||
                    (ch1 == '(' && ch2 == ')') ||
                    (ch1 == '[' || ch2 == ']') ||
                    (ch1 == '<' && ch2 == '>')){
                 return true;
            }
            return false;
        }
}




