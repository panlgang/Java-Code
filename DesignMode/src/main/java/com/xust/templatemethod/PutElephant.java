package com.xust.templatemethod;

/**
 * @auther plg
 * @date 2019/7/17 13:09
 */
public class PutElephant extends PutFridge {
    @Override
    public void openDoor() {
        System.out.println("轻轻地打开冰箱门！");
    }
    @Override
    public void put() {
        System.out.println("将大象轻轻放进去！");
    }
    @Override
    public void closeDoor() {
        System.out.println("轻轻地关闭冰箱门！");
    }
}
