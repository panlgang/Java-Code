package com.github.excellent;

/**
 * 验证Java没有采用引用记数法,打印GC日志 ： -XX: + PrintGCDetails
 * @auther plg
 * @date 2019/6/24 20:25
 */
public class RefenceCountGC {
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[_1MB];
    public Object obj = null;

    public static void main(String[] args) {
        RefenceCountGC re1 = new RefenceCountGC();
        RefenceCountGC re2 = new RefenceCountGC();
        re1.obj = re2;
        re2.obj = re1;
        re1 = re2 = null;
        System.gc();
    }
}
