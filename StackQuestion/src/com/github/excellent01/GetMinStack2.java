package com.github.excellent01;

import java.util.Stack;

/**
 * @auther plg
 * @date 2019/5/22 19:32
 */
public class GetMinStack2 {
    Stack<Integer> stack = new Stack<>();
    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int temp = stack.peek();
            stack.push(x);
            if(temp < x){
                stack.push(temp);
            }else{
                stack.push(x);
            }
        }
    }
    public int peek(){
        int data = stack.pop();
        int ret = stack.pop();
        stack.push(data);
        return ret;
    }
    public int pop(){
        stack.pop();
        return stack.pop();
    }
    public int getMin(){
        return stack.peek();
    }

}
