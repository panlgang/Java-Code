package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/4/13 11:45
 */
interface Add{
    int add(int a,int b);
}
// 普通内部类
class AddImpl implements Add{
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
public class TestLambda {
    public static void main(String[] args) {
        //匿名内部类
        Add sum = new Add(){
            @Override
            public int add(int a,int b){
                return a + b;
            }
        };
        Add sum2 = (a,b) -> a + b;
        System.out.println("普通内部类" + new AddImpl().add(10,20));
        System.out.println("匿名内部类：" + sum.add(10,20));
        System.out.println("Lanbda表达式：" +  sum2.add(10,20));
    }
}
