package com.xust.templatemethod;
/**
 * @auther plg
 * @date 2019/7/17 13:02
 */
public abstract class PutFridge {
    public abstract void openDoor();
    public abstract void put();
    public abstract void closeDoor();

    /**
     * 声明为final，防止子类覆写进而修改
     */
    protected final void finish(){
        openDoor();
        put();
        closeDoor();
    }
}

