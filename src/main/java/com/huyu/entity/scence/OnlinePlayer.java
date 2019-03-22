package com.huyu.entity.scence;

import com.huyu.entity.Player;

import java.util.HashMap;

public class OnlinePlayer {
    private HashMap<String, Player> players = new HashMap<>();
    private static OnlinePlayer onlinePlayer ;
    private OnlinePlayer() {
    }
    public static OnlinePlayer getOnlinePlayer(){
        if( onlinePlayer == null){
           onlinePlayer = new OnlinePlayer();
        }
        return onlinePlayer;
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
