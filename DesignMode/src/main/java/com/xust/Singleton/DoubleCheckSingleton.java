package com.xust.Singleton;

public class DoubleCheckSingleton {
    private static DoubleCheckSingleton ourInstance = null;

    public static DoubleCheckSingleton getInstance() {
        if(ourInstance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (ourInstance == null) {
                    ourInstance = new DoubleCheckSingleton();
                }
            }
        }
        return ourInstance;
    }

    private DoubleCheckSingleton() {
    }

    public static void main(String[] args) {
        DoubleCheckSingleton d1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton d2 = DoubleCheckSingleton.getInstance();
        System.out.println(d1 == d2);
    }
}
