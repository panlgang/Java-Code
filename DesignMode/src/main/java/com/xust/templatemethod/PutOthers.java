package com.xust.templatemethod;

/**
 * @auther plg
 * @date 2019/7/17 13:22
 */
public class PutOthers extends PutFridge{
    @Override
    public void openDoor() {
        System.out.println("慢慢地打开冰箱门！");
    }
    @Override
    public void put() {
        System.out.println("将其它东西装进去!");
    }
    @Override
    public void closeDoor() {
        System.out.println("慢慢地关闭冰箱门！");
    }
}
