package com.github.excellent;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @auther plg
 * @date 2019/6/24 20:45
 */
public class PhantomR {
    public static void main(String[] args) {
        String str = "hello";
        PhantomReference<String> phantomReference = new PhantomReference<>(str,new ReferenceQueue<>());
        str = null;
    }
}
