package com.github.excellent;

/**
 * -XX:PrintGC : 可以打印GC日志
 * @auther plg
 * @date 2019/5/3 15:34
 */
public class TestGC {
    private static int _1MB = 1024 * 1024;
    private byte[] arr = new byte[2 * _1MB];
    private Object instance = null;
    public static void main(String[] args) {
        TestGC test1 = new TestGC();
        TestGC test2 = new TestGC();
        test1.instance = test2;
        test2.instance = test1;
        test1 = test2 = null;
        // 强制进行垃圾回收
        System.gc();
    }
}
