package com.xust.FactoryMethod.SimpleFactory;

/**
 * @auther plg
 * @date 2019/7/17 15:52
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.newInstance("AppleBook");
        computer.printComputer();
    }
}
