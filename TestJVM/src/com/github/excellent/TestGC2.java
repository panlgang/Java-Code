package com.github.excellent;

/**
 * 对象的自救
 * 最终将对象挂到哪个上面判断哪个
 * @auther plg
 * @date 2019/5/3 15:40
 */
public class TestGC2 {
    public static TestGC2 test;
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("开始自救.....");
        test = this;
    }

    public static void main(String[] args) throws InterruptedException {
        TestGC2 test = new TestGC2();
        test = null;
        System.gc();
        Thread.sleep(500);
        if(TestGC2.test == null){
            System.out.println("Dead...");
        }else{
            System.out.println("Alive");
        }

        test = null;
        System.gc();
        Thread.sleep(500);
        if(test == null){
            System.out.println("Dead...");
        }else{
            System.out.println("Alive");
        }

    }
}
