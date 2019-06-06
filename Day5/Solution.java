package Day5;

import java.util.Stack;

/**
 * @auther plg
 * @date 2019/5/24 14:08
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }
}


