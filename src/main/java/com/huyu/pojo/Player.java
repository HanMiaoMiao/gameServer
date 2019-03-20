package com.huyu.pojo;

public class Player {
    private Integer playerId;
    private String playerName;
    private String currentlyScene;
    private int status = 1;
    private String password;
    private int backpackID;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCurrentlyScene() {
        return currentlyScene;
    }

    public void setCurrentlyScene(String currentlyScene) {
        this.currentlyScene = currentlyScene;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", currentlyScene='" + currentlyScene + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }

    public int getBackpackID() {
        return backpackID;
    }

    public void setBackpackID(int backpackID) {
        this.backpackID = backpackID;
    }
}
