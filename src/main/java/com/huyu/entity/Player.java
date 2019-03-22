package com.huyu.entity;

import com.huyu.entity.prop.Prop;
import com.huyu.entity.scence.Scence;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable {
    //玩家当前场景
    private static final long  SerialVersionUID = 1L;
    private Integer playerId;
    private String playerName;
    private Scence currentlyScene;
    private int status = 1;
    private String password;
    /**
     * 背包
     */
    private HashMap<Integer, Prop> backpack;
    /**
     * 装备栏
     */
    private HashMap<Integer, Prop> equipment;
    /**
     * 技能
     */
    private HashMap<Integer, Skill> skills;
    /**
     *魔法
     */
    private MP playerMp ;
    /**
     * 血量
     */
    private HP playerHP;
    /**
     * 角色攻击属性
     */
    private int attack;
    /**
     * 角色伤害
     */
    private int playerHarm;
    /**
     * 药水叠加次数
     */
    private int overlappingTimes=0;


    public Scence getCurrentlyScene() {
        return currentlyScene;
    }

    public int isStatus() {
        return status;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentlyScene(Scence currentlyScene) {
        this.currentlyScene = currentlyScene;
    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof Player){
            Player player = (Player)o;
            if (player.getName() == null || this.playerName == null){
                return false;
            }else{
                return  this.playerName.equals(player.getName());
            }
        }
        return false;
    }

    public HashMap<Integer, Skill> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<Integer, Skill> skills) {
        this.skills = skills;
    }

    public MP getPlayerMp() {
        return playerMp;
    }

    public void setPlayerMp(MP playerMp) {
        this.playerMp = playerMp;
    }

    public int getPlayerHarm() {
        return playerHarm;
    }

    public void setPlayerHarm(int playerHarm) {
        this.playerHarm = playerHarm;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public HashMap<Integer, Prop> getBackpack() {
        return backpack;
    }

    public void setBackpack(HashMap<Integer, Prop> backpack) {
        this.backpack = backpack;
    }

    public HashMap<Integer, Prop> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashMap<Integer, Prop> equipment) {
        this.equipment = equipment;
    }

    public int getOverlappingTimes() {
        return overlappingTimes;
    }

    public void setOverlappingTimes(int overlappingTimes) {
        this.overlappingTimes = overlappingTimes;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public HP getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(HP playerHP) {
        this.playerHP = playerHP;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", currentlyScene=" + currentlyScene.getSceneName() +
                ", playerMp=" + playerMp.getCurrentmp() +
                ", playerHP=" + playerHP.getCurrentHP() +
                ", 叠加药水的次数=" + overlappingTimes +
                '}';
    }
}
