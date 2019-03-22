package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoveCommand extends Command {

    public MoveCommand(String playerName){
        super(playerName);
    }
    @Override
    public MessageProtocol serverExcute() {
        //在线玩家
        HashMap<String, Player> map = OnlinePlayer.getOnlinePlayer().getPlayers();
        //
        Player player = map.get(super.getPlayerName());

        String[] option = super.getOption();
        HashMap<String,Scence> borderScence = (HashMap<String, Scence>) player.getCurrentlyScene().getBorderScene();
        MessageProtocol messageProtocol;
        //遍历集合，能否移动到要去的场景
        for(Map.Entry<String,Scence> s :borderScence.entrySet()){
            if(s.getValue().getSceneName().equals(option[0])){
                //从当前场景中移除player
                player.getCurrentlyScene().getPlayers().remove(player);
                //将player加入到新场景
                s.getValue().getPlayers().put(player.getName(),player);
                player.setCurrentlyScene(s.getValue());

                byte[] bytes = ConvertFunction.toByte(player.getCurrentlyScene());
                //byte[] bytes = ConvertFunction.toByte(s);
                //将场景信息返回给客户端
                messageProtocol = new MessageProtocol(bytes.length, Type.SCENCE,bytes);
                return messageProtocol;
            }
        }
        String str = "你不能到达："+option;
        messageProtocol = new MessageProtocol(str.getBytes().length, Type.STRING,str.getBytes());
        System.out.println(messageProtocol);
        return messageProtocol;

    }
}
