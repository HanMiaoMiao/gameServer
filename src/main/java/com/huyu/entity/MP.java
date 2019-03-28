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
    int minMp = 500;
    /**
     * 当前的mp
     */
    int currentmp = maxMp;
    /**
     * 每秒自动恢复的mp
     */
    int mp = 2;

    /**
     * 自动恢复mp
     * 每秒恢复100
     */
    @Override
    public void run() {
        while(currentmp <= 700){
            currentmp += mp;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentmp() {
        return currentmp;
    }

    public void setCurrentmp(int currentmp) {
        this.currentmp = currentmp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getMinMp() {
        return minMp;
    }

    public void setMinMp(int minMp) {
        this.minMp = minMp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
}
