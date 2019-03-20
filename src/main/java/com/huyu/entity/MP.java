package com.huyu.entity;

import java.io.Serializable;

/**
 * 魔法
 */
public class MP implements Serializable,Runnable{
    private static final long  SerialVersionUID = 1L;
    /**
     * 最大的mp
     */
    int maxMp = 1000;
    /**
     * 当前的mp
     */
    int currentmp = maxMp;
    /**
     * 每秒自动恢复的mp
     */
    int mp = 100;

    /**
     * 自动恢复mp
     * 每秒恢复100
     */
    @Override
    public void run() {
        while(currentmp <= maxMp){
            currentmp += mp;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentmp = maxMp;
    }

    public int getCurrentmp() {
        return currentmp;
    }

    public void setCurrentmp(int currentmp) {
        this.currentmp = currentmp;
    }
}
