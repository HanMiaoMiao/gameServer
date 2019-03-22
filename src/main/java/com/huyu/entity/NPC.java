package com.huyu.entity;

import java.io.Serializable;

public class NPC implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private int npcId;
    private String npcName;
    private String talk;

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public String getNpcName() {
        return npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "npcId=" + npcId +
                ", npcName='" + npcName + '\'' +
                ", talk='" + talk + '\'' +
                '}';
    }
}
