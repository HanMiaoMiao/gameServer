package com.huyu.service.impl;

import com.huyu.dao.PlayerDao;
import com.huyu.entity.Player;
import com.huyu.entity.scence.Begin;
import com.huyu.service.PlayerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PlayerServiceImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private PlayerService playerService = (PlayerService)context.getBean("playerService");
    @Test
    public void addPlayer() {
        Player player = new Player();
        player.setName("mi");
        player.setPassword("mi");
        player.setCurrentlyScene(Begin.getBegin());
        playerService.addPlayer(player);
        System.out.println(player);
    }

    @Test
    public void deletePlayer() {
    }

    @Test
    public void updatePlayer() {
    }

    @Test
    public void selectPlayer() {
        Player player = new Player();
        player.setName("mm");
        player.setPassword("mm");

        playerService.selectPlayer(player);
        System.out.println(playerService.selectPlayer(player));
    }
}