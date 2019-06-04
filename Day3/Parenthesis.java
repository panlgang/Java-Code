package Day3;

import java.util.Stack;

/**
 * 括号匹配问题
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @auther plg
 * @date 2019/5/21 22:37
 */

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        if(A == null || n <= 1){
            return false;
        }
        return chkParenthesis(A);
    }
    public boolean chkParenthesis(String A){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < A.length(); i++){
            char ch1 = A.charAt(i);
            char ch2 = '\u0000';
            if(ch1 == '(' || ch1 == '[' || ch1 == '{' ){
                stack.push(ch1);
            }else if(ch1 == ')'|| ch1 == ']' || ch1 == '}'){
                if(!stack.isEmpty()){
                    ch2 = stack.pop();
                }
                if(!isRight(ch2,ch1)){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
    public boolean isRight(char ch1,char ch2){
        if(ch1 == '(' && ch2 == ')'){
            return true;
        }
        if(ch1 == '[' && ch2 == ']'){
            return true;
        }
        if(ch1 == '{' && ch2 == '}'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.println( parenthesis.chkParenthesis("{(})",9));
    }
}
