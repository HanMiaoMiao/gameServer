package com.huyu.entity.scence;

import com.huyu.entity.Monster;
import com.huyu.entity.NPC;
import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Scence implements Serializable {
    private static final long SerialVersionUID = 1L;
    /**
     * 场景ID
     */
    private Integer sceneId;
    /**
     * 场景名称
     */
    private String sceneName;
    /**
     * 相邻的场景
     */
    private Map<String, Scence> borderScene;
    /**
     * 场景中的玩家
     */
    private Map<String, Player> players;
    /**
     * 场景中的npc
     */
    private Map<Integer, NPC> npcs;
    /**
     * 场景中的怪物
     */
    private Map<Integer, Monster> monsters;

    public Integer getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public Map<String, Scence> getBorderScene() {
        return borderScene;
    }

    public void setBorderScene(Map<String, Scence> borderScene) {
        this.borderScene = borderScene;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = players;
    }

    public Map<Integer, NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(Map<Integer, NPC> npcs) {
        this.npcs = npcs;
    }

    public Map<Integer, Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(Map<Integer, Monster> monsters) {
        this.monsters = monsters;
    }

}
