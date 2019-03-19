package com.huyu.pojo;

import com.huyu.entity.scence.Scence;

import java.util.Arrays;

public class Player {
    private Integer playerId;
    private String playerName;
    private byte[] currentlyScene;
    private int status = 1;
    private String password;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayName() {
        return playerName;
    }

    public void setPlayName(String playName) {
        this.playerName = playName;
    }

    public byte[] getCurrentlyScene() {
        return currentlyScene;
    }

    public void setCurrentlyScene(byte[] currentlyScene) {
        this.currentlyScene = currentlyScene;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", currentlyScene=" + Arrays.toString(currentlyScene) +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
