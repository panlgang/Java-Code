package com.xust.FactoryMethod.SimpleFactory;

/**
 * @auther plg
 * @date 2019/7/17 15:50
 */
public class ComputerFactory {
    public static Computer newInstance(String name){
        Computer instance = null;
        if(name.equals("AppleBook")){
            instance = new AppleBook();
        }else if(name.equals("MacBook")){
            instance = new MacBook();
        }
        return instance;
    }
}
