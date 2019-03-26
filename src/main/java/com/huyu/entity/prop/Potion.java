package com.huyu.entity.prop;

import com.huyu.entity.Player;

/**
 * 药水
 */
public class Potion extends Prop{
    private int potionId;
    private int mp;
    private String name;
    private byte type;

    /**
     * 使用药水，增加mp
     */
    @Override
    public String effect(Player player) {
        int currentMp = player.getPlayerMp().getCurrentmp();
        int maxMP = player.getPlayerMp().getMaxMp();
        if(player.getOverlappingTimes()<= 100){
            currentMp = currentMp+mp;
            player.getPlayerMp().setCurrentmp(currentMp> maxMP ? maxMP : currentMp);
            player.setOverlappingTimes(player.getOverlappingTimes() + 1);
            player.getBackpack().remove(potionId);
            return "现在的魔力值:"+ (player.getPlayerMp().getCurrentmp());
        }else{
            return "药水使用次数已超过100次";
        }
    }

    public int getPotionId() {
        return potionId;
    }

    public void setPotionId(int potionId) {
        this.potionId = potionId;
        super.setId(potionId);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        super.setPropName(name);
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "potionId=" + potionId +
                ", mp=" + mp +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
