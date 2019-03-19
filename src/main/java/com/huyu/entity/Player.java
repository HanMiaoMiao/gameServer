package com.huyu.entity;

import com.huyu.entity.scence.Begin;
import com.huyu.entity.scence.Scence;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private Integer playerId;
    private String playerName;
    /**
     * 玩家当前场景
     */
    private Scence currentlyScene;
    /**
     * 生存状态
     */
    private int  status = 1;
    private String password;

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
}
