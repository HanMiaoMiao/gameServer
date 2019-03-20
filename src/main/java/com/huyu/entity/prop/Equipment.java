package com.huyu.entity.prop;

import com.huyu.entity.Player;

/**
 * 装备
 */
public class Equipment extends Prop {
    private int equipmentId;
    private String equipmentName;
    private boolean wear;
    /**
     * 攻击属性
     */
    private int attack;
    /**
     * 耐久度
     */
    private int durability;
    /**
     * 技能伤害
     */
    private int harm;
    /**
     *装备效果
     */
    @Override
    public String effect(Player player) {
        //给角色增加攻击属性
        player.setAttack(player.getAttack()+attack);
        //给角色增加技能伤害
        player.setPlayerHarm(player.getPlayerHarm()+harm);
        //设置装备属性为穿
        this.setWear(true);
        //将装备放入装备栏
        player.getEquipment().put(equipmentId,this);
        //从背包移除
        player.getBackpack().remove(equipmentId);
        return "攻击属性"+ player.getAttack()+"伤害"+player.getPlayerHarm();
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public boolean isWear() {
        return wear;
    }

    public void setWear(boolean wear) {
        this.wear = wear;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getHarm() {
        return harm;
    }

    public void setHarm(int harm) {
        this.harm = harm;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", wear=" + wear +
                ", attack=" + attack +
                ", durability=" + durability +
                ", harm=" + harm +
                '}';
    }
}
