package com.github.excellent01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @auther plg
 * @date 2019/4/30 14:59
 */
public class MyLock implements Lock {
     private final FairSync fairSync;
     public MyLock(){
         fairSync = new FairSync();
     }
    static class FairSync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            Thread thread = Thread.currentThread();
            int state = getState();
            if(state == 0){
                if(hasQueuedPredecessors()){
                    return false;
                }else if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(thread);
                    return true;
                }else{
                    return false;
                }
            }
            boolean flag = isHeldExclusively();
            if(flag){
                // 锁的可重入
                compareAndSetState(state,state + arg);
                setExclusiveOwnerThread(thread);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int state = getState();
            int newState = state - arg;
            setState(newState);
            if(newState == 0) {
                setExclusiveOwnerThread(null);
            }
            return true;
        }
    }
    @Override
    public void lock() {
         fairSync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        fairSync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return fairSync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return fairSync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
         fairSync.release(1);

    }
    @Override
    public Condition newCondition() {
        return null;
    }
}
