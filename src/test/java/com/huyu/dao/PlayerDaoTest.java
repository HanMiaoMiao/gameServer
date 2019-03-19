package com.huyu.dao;

import com.huyu.entity.scence.Begin;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.pojo.Player;
import com.huyu.service.PlayerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PlayerDaoTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private PlayerDao playerDao = (PlayerDao)context.getBean("playerDao");
    //Player findByName(String playerName);
    //int addPlayer(Player player);
    //int deletePlayerByName(String playerName);
    //int updatePlayer(Player player);
    @Test
    public void findByName() {
        System.out.println(playerDao.findByName("mm"));
    }

    @Test
    public void updatePlayer() {
    }

    @Test
    public void addPlayer() {
        Player player = new Player();
        player.setPlayName("mi");
        player.setPassword("mi");
        player.setCurrentlyScene(ConvertFunction.toByte(Begin.getBegin()));
        System.out.println(playerDao.addPlayer(player));
    }
    @Test
    public void deletePlayer() {
    }
}