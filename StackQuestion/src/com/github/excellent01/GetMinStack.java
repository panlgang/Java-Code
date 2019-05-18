package com.github.excellent01;

import java.util.Stack;

/**
 * 实现一个特殊的栈，要求：
 * push，pop，getMin 均是O(1)。
 * @auther plg
 * @date 2019/5/18 8:41
 */
public class GetMinStack {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();
    public  void push(int num){
        stackData.push(num);
        if(stackMin.isEmpty() || stackMin.peek() > num){
            stackMin.push(num);
        }else {
           stackMin.push(stackMin.peek());
        }
    }
    public int pop() {
        if(stackData.isEmpty()){
            stackMin.pop();
            return stackData.pop();
        }else{
            throw new RuntimeException("Your Stack Is Empty");
        }
    }
    public int getMin(){
       if(stackMin.isEmpty()){
           throw new RuntimeException("Your Stack Is Empty");
       }
       return stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(2);
        getMinStack.push(3);
        getMinStack.push(2);
        getMinStack.push(4);
        getMinStack.push(1);
        System.out.println(getMinStack.getMin());
    }


}
