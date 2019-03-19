package com.huyu.service;

import com.huyu.dao.PlayerDao;
import com.huyu.entity.Player;
import com.huyu.entity.scence.Begin;
import com.huyu.entity.scence.Scence;

import java.util.Scanner;

public class Register {
    private PlayerDao playerDao;
    //注册
    public boolean register(Player player){
        Player player1 = new Player();
        player1.setName(player.getName());
        player1.setCurrentlyScene(Begin.getBegin());
        Begin.getBegin().getPlayers().add(player);
        //return playerDao.findByName();
        return true;

    }
}
