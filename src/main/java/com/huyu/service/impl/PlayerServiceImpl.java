package com.huyu.service.impl;

import com.huyu.dao.PlayerDao;
import com.huyu.entity.Player;
import com.huyu.entity.scence.Begin;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Scope("prototype")
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
    @Resource(name = "playerDao")
    private PlayerDao playerDao;

    @Override
    //注册
    public boolean addPlayer(Player player) {
        if(playerDao.findByName(player.getName())==null){

            //给玩家设置场景信息，以及其他信息
            //设置初始信息
            System.out.println(playerDao.findByName(player.getName()));
            com.huyu.pojo.Player p = new com.huyu.pojo.Player();
            p.setPlayName(player.getName());
            p.setPassword(player.getPassword());
            //p.setCurrentlyScene(ConvertFunction.toByte(Begin.getBegin()));
            playerDao.addPlayer(p);
            return true;
        }else{
            return false;
        }


    }

    @Override
    public int deletePlayer(Integer playerId) {
        return 0;
    }

    @Override
    public int updatePlayer(Player player) {
        return 0;
    }

    @Override
    //login
    public boolean selectPlayer(Player player) {
        com.huyu.pojo.Player p = playerDao.findByName(player.getName());
        System.out.println(p);
        if(p!=null) {
            //若找到在当前层重新将玩家加入场景
            //还原玩家的基本信息
            player.setCurrentlyScene(Begin.getBegin());
            Begin.getBegin().getPlayers().add(player);
            return true;
        }else {
            //若未找到，返回错误信息
            return false;
        }
    }
}
