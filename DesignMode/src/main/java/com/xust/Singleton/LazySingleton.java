package com.xust.Singleton;

public class LazySingleton {
    private static LazySingleton ourInstance = null;

    public static LazySingleton getInstance() {
        if(ourInstance == null){
            ourInstance = new LazySingleton();
        }
        return ourInstance;
    }

    private LazySingleton() {
    }
}
