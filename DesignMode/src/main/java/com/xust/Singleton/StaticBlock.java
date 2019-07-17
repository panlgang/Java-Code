package com.xust.Singleton;

/**
 * @auther plg
 * @date 2019/7/17 17:23
 */
public class StaticBlock {
    private static StaticBlock instance = null;
    private StaticBlock(){}
    static{
        instance = new StaticBlock();
    }

    public static StaticBlock getInstance() {
        return instance;
    }
}
