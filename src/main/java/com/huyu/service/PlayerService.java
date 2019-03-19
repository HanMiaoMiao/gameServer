package com.huyu.service;


import com.huyu.entity.Player;

public interface PlayerService {
    boolean addPlayer(Player player);
    int deletePlayer(Integer playerId);
    int updatePlayer(Player player);
    boolean selectPlayer(Player player);
}
