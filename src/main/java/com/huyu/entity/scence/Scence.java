package com.huyu.entity.scence;

import com.huyu.entity.Monster;
import com.huyu.entity.NPC;
import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Scence implements Serializable {
    private static final long SerialVersionUID = 1L;
    private static Integer sceneId;
    private String sceneName;
    private Map<String, Scence> borderScene;
    private HashMap<String, Player> players;


    private Map<Integer, NPC> npcs;
    //怪物
    private Map<Integer, Monster> monsters;

    public static Integer getSceneId() {
        return sceneId;
    }

    public static void setSceneId(Integer sceneId) {
        Scence.sceneId = sceneId;
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

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<String, Player> players) {
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
