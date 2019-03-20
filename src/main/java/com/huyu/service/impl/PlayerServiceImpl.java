package com.huyu.service.impl;

import com.huyu.dao.PlayerDao;
import com.huyu.entity.HP;
import com.huyu.entity.MP;
import com.huyu.entity.Player;
import com.huyu.entity.Skill;
import com.huyu.entity.prop.Prop;
import com.huyu.entity.scence.Scence;
import com.huyu.entity.scence.World;
import com.huyu.netty.handler.server.ServerInitializer;
import com.huyu.service.PlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;


@Scope("prototype")
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
    @Resource(name = "playerDao")
    private PlayerDao playerDao;
    @Resource(name = "scenes")
    private World scence ;
    private ApplicationContext context = ServerInitializer.CONTEXT;
    @Override
    //注册
    public boolean addPlayer(Player player) {
        if(playerDao.findByName(player.getName())==null){
            //给玩家设置场景信息，以及其他信息
            //设置初始信息
            //System.out.println(playerDao.findByName(player.getName()));
            com.huyu.pojo.Player p = new com.huyu.pojo.Player();

            p.setPlayerName(player.getName());
            //设置密码
            p.setPassword(player.getPassword());
            //设置初始场景
            p.setCurrentlyScene("begin");
            //设置背包ID
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

    /**
     * 1.恢复玩家基本信息
     * 2.将玩家加入到场景
     * 3.构建技能系统
     * 4.构建背包
     * @param player
     * @return
     */
    @Override
    //login
    public boolean selectPlayer(Player player) {
        com.huyu.pojo.Player p = playerDao.findByName(player.getName());
        //System.out.println(p);
        HashMap<String, Scence> scences = (HashMap<String, Scence>) scence.getScences();
        if(p!=null) {
            player.setPlayerId(p.getPlayerId());
            //设置基础伤害
            player.setPlayerHarm(100);
            //设计攻击属性
            player.setAttack(100);
            //设置HP
            player.setPlayerHP(new HP());
            //设置MP
            player.setPlayerMp(new MP());
            //若找到在当前层重新将玩家加入场景
            //还原玩家的基本信息
            //构建技能系统
            //从数据库中找到查询到的道具ID
            ArrayList<Integer> propID = playerDao.findProp(p.getPlayerId());
            //添加背包
            HashMap<Integer, Prop> backpack = new HashMap();
            if(propID != null){
                for(Integer i :propID){
                    backpack.put(i,(Prop)context.getBean(Integer.toString(i)));
               }
            }
            player.setBackpack(backpack);
            //装备
            player.setEquipment(new HashMap<Integer, Prop>());
            HashMap<Integer, Skill> skills = new HashMap<>();
            //添加技能
            skills.put(1,(Skill)context.getBean(Integer.toString(1)));
            skills.put(2,(Skill)context.getBean(Integer.toString(2)));
            //设置场景
            Scence current = scences.get(p.getCurrentlyScene());
            player.setCurrentlyScene(current);
            //将玩家加入到世界中
            current.getPlayers().put(p.getPlayerName(),player);
            return true;
        }else {
            //若未找到，返回错误信息
            return false;
        }
    }
}
