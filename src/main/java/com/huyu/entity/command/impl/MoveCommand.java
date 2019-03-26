package com.huyu.entity.command.impl;

import com.google.protobuf.ByteString;
import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.MessageProto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoveCommand extends Command {

    public MoveCommand(String playerName){
        super(playerName);
    }

    @Override
    public void setType(MessageProto.Message.Builder builder) {
        builder.setType(MessageProto.MSG.Move_Req);
    }

    @Override
    public MessageProto.Message serverExcute() {
        //在线玩家
        HashMap<String, Player> map = OnlinePlayer.getOnlinePlayer().getPlayers();
        //
        Player player = map.get(super.getPlayerName());

        String[] option = super.getOption();
        HashMap<String,Scence> borderScence = (HashMap<String, Scence>) player.getCurrentlyScene().getBorderScene();
        MessageProto.Message.Builder builder = MessageProto.Message.newBuilder();
        //遍历集合，能否移动到要去的场景
        for(Map.Entry<String,Scence> s :borderScence.entrySet()){
            if(s.getValue().getSceneName().equals(option[0])){
                //从当前场景中移除player
                player.getCurrentlyScene().getPlayers().remove(player);
                //将player加入到新场景
                System.out.println("move+"+s.getValue());
                System.out.println("move+"+s.getValue().getPlayers());
                System.out.println(player.getName());
                s.getValue().getPlayers().put(player.getName(),player);
                player.setCurrentlyScene(s.getValue());
                String inform = "你已到达"+s.getValue().getSceneName();
                return resp(builder,inform);
            }
        }
        String str = "你不能到达："+option;
        return resp(builder,str);

    }
    private MessageProto.Message resp(MessageProto.Message.Builder builder,String inform){
        builder.setObj(ByteString.copyFromUtf8(inform));
        builder.setType(MessageProto.MSG.Move_Resp);
        return builder.build();
    }
}
