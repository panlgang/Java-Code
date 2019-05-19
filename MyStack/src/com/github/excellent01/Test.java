package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/5/19 17:50
 */
public class Test {
    public static void main(String[] args) {
        AbstractMyStack<Integer> stack = new ArrayStack<>(5);
        for(int i = 0; i < 5; i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
//        System.out.println(stack.getCount());
//        System.out.println(stack.isEmpty());
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
    }
}
