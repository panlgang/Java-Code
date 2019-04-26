package com.github.excellent;

/**
 * 最大到660MB就OOM
 * @auther plg
 * @date 2019/4/26 22:05
 */
public class TestOOM {
    public static void main(String[] args) {
        byte[] arr = new byte[660*1024*1024];
    }
}
// byte--> kb-->mb
