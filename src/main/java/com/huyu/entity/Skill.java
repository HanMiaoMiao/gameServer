package com.huyu.entity;

import java.io.Serializable;

/**
 * 技能
 */
public class Skill implements Serializable {
    private static final long  SerialVersionUID = 1L;
    /**
     * 技能ID
     */
    private int skillId;
    /**
     * 技能名称
     */
    private String skillName;
    /**
     * 使用一次技能造成的伤害
     */
    private int harm;
    /**
     * 使用一次技能之后间隔的时间
     */
    private int cd ;
    /**
     * 使用一次技能消耗的mp
     */
    int mp;
    /**
     * 上一次使用该技能的时间
     */
    private long lastTime = System.currentTimeMillis();

    public Skill() {
    }

    public Skill(int skillId, String skillName, int harm, int cd, int mp, long lastTime) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.harm = harm;
        this.cd = cd;
        this.mp = mp;
        this.lastTime = lastTime;
    }



    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getHarm() {
        return harm;
    }

    public void setHarm(int harm) {
        this.harm = harm;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }
}
