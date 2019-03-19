package com.huyu.entity;

import com.huyu.entity.scence.Begin;
import com.huyu.entity.scence.Scence;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    //玩家当前场景
    private static final long  SerialVersionUID = 1L;
    private Integer playerId;
    private String playerName;
    private Scence currentlyScene;
    private int   status = 1;
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


    public void move(Begin goingScene){
        for (Scence c: currentlyScene.getBorderScene()) {
            if(c.getSceneName().equals(goingScene.getSceneName())){
                //移除实体
                currentlyScene.getPlayers().remove(this);
                setCurrentlyScene(goingScene);
                //添加实体
                goingScene.getPlayers().add(this);
                System.out.println("您已到达:  "+goingScene.getSceneName());
                return;
            }
        }
        System.out.println("您不能直接到达:  "+goingScene.getSceneName());
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
