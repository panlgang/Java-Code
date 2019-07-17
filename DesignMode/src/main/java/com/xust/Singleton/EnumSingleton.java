package com.xust.Singleton;

public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return EnumSingleton.INSTANCE;
    }
}
