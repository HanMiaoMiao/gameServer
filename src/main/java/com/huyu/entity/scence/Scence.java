package com.huyu.entity.scence;

import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Scence implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private ArrayList<Scence> borderScene;
    private ArrayList<Player> players ;
    private Integer sceneId;
    private String sceneName;
    public Scence(ArrayList<Scence> borderScene, ArrayList<Player> players, Integer sceneId, String sceneName) {
        this.borderScene = borderScene;
        this.players = players;
        this.sceneId = sceneId;
        this.sceneName = sceneName;
    }
    public  ArrayList<Scence> getBorderScene() {
        return borderScene;
    }

    public void setBorderScene(ArrayList<Scence> borderScene) {
        this.borderScene = borderScene;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public  void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Integer getSceneId() {
        return sceneId;
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
}
