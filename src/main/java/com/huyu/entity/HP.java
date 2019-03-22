package com.huyu.entity;

import java.io.Serializable;

/**
 * 血
 */
public class HP implements Serializable {
    private static final long  SerialVersionUID = 1L;

    /**
     * 最大血量
     */
    int maxHP = 10000;
    /**
     * 现在的血量
     */
    int currentHP = maxHP;


    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}
