package com.huyu.entity.command.impl;

import com.huyu.entity.Monster;
import com.huyu.entity.Player;
import com.huyu.entity.Skill;
import com.huyu.entity.command.Command;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;

/**
 * 攻击命令
 */
public class AttackCommand extends Command {
    public AttackCommand(String playerName) {
        super(playerName);
    }

    /**
     * 1.在技能类中增加上一次使用技能的时间，使用技能时用当前时间减去上一次使用技能的时间，和CD时间比较
     * 2.判断mp是否够用，若不够用，无法使用技能
     * 3.mp自动恢复
     * @return
     */
    @Override
    public MessageProtocol serverExcute() {
        System.out.println("attack");
        MessageProtocol mg;
        String resp;
        Player player = super.getMap().get(super.getPlayerName());
        String[] str = super.getOption();
        //从消息中获取要攻击的怪物
        Monster monster = player.getCurrentlyScene().getMonsters().get(Integer.parseInt(str[0]));
        //从消息中获取要使用的技能
        System.out.println("Skill"+player.getSkills());
        Skill skill = player.getSkills().get(Integer.parseInt(str[1]));
        //得到怪物的生命值
        int monsterblood = monster.getMonsterBlood();
        if(monsterblood < 0){
            resp = "怪物已经死亡";
            return new MessageProtocol(resp.getBytes().length, Type.STRING,resp.getBytes());
        }
        //获得玩家剩余的mp
        int playerMp = player.getPlayerMp().getCurrentmp();
        //获得技能需要的mp
        int skillMp = skill.getMp();
        //若玩家当前的 mp > 技能需要的mp 则能使用技能
        if(playerMp > skillMp){
            //判断CD时间
            if(System.currentTimeMillis()-skill.getLastTime()>skill.getCd()){
                //角色基础伤害+技能伤害

                //怪物攻击玩家
                int playerHp = player.getPlayerHP().getCurrentHP();
                //判断角色活着吗
                if(playerHp < 0){
                    player.setStatus(0);
                    resp = "你已经死亡";
                    return new MessageProtocol(resp.getBytes().length, Type.STRING,resp.getBytes());
                }
                monster.setMonsterBlood(monsterblood-skill.getHarm()-player.getPlayerHarm());
                player.getPlayerHP().setCurrentHP(playerHp-monster.getHarm());
                //设置这一次技能使用的时间
                skill.setLastTime(System.currentTimeMillis());
                //设置角色剩余mp
                player.getPlayerMp().setCurrentmp(playerMp - skillMp);
                //开启线程，让玩家mp自动恢复
                if(player.getPlayerMp().getCurrentmp()<(player.getPlayerMp().getMaxMp()/2)){
                    Thread thread = new Thread(player.getPlayerMp());
                    thread.start();
                }
                //设置装备耐久度
                resp = monster.toString()+"\n"+player.toString();
                return new MessageProtocol(resp.getBytes().length, Type.STRING,resp.getBytes());
            }else{
                resp= "技能CD未到，现在不能使用该技能";
                mg = new MessageProtocol(resp.getBytes().length, Type.STRING,resp.getBytes());
                return mg;
            }
        }else{
            resp = "mp不足，不能使用技能";
            return new MessageProtocol(resp.getBytes().length, Type.STRING,resp.getBytes());
        }
    }
}
