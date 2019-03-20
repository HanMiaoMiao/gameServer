package com.huyu.entity;

import java.io.Serializable;

/**
 * 怪物
 */
public class Monster implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private int monsterId;
    private String monsterName;
    private int monsterBlood = 100;
    private int harm;
    private boolean status;

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterBlood() {
        return monsterBlood;
    }

    public void setMonsterBlood(int monsterBlood) {
        this.monsterBlood = monsterBlood;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHarm() {
        return harm;
    }

    public void setHarm(int harm) {
        this.harm = harm;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", monsterName='" + monsterName + '\'' +
                ", monsterBlood=" + monsterBlood +
                ", status=" + status +
                '}';
    }
}
