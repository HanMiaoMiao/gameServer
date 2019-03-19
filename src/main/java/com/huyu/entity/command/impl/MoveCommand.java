package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;

import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;

import java.util.ArrayList;
import java.util.HashMap;

public class MoveCommand extends Command {
    public MoveCommand(String playerName){
        super(playerName);
    }
    @Override
    public MessageProtocol excute() {
        byte[] bc = ConvertFunction.toByte(this);
        MessageProtocol messageProtocol = new MessageProtocol(bc.length,Signe.H3,bc);
        return messageProtocol;
    }

    @Override
    public MessageProtocol serverExcute() {
        System.out.println("serverExcute");
        HashMap<String,Player> map = OnlinePlayer.getOnlinePlayer().getPlayers();
        Player player = map.get(super.getPlayerName());
        System.out.println(player);
        String option = super.getOption();
        System.out.println(option);
        ArrayList<Scence> borderScence = player.getCurrentlyScene().getBorderScene();
        MessageProtocol messageProtocol;
        for (Scence s : borderScence) {
            if(s.getSceneName().equals(option)){
                System.out.println(option);
                player.getCurrentlyScene().getPlayers().remove(player);
                s.getPlayers().add(player);
                player.setCurrentlyScene(s);
                byte[] bytes = ConvertFunction.toByte(s);
                messageProtocol = new MessageProtocol(bytes.length,Type.SCENCE,bytes);
                System.out.println(messageProtocol);
                return messageProtocol;
            }
        }
        String str = "你不能到达："+option;
        messageProtocol = new MessageProtocol(str.getBytes().length,Type.STRING,str.getBytes());
        System.out.println(messageProtocol);
        return messageProtocol;
    }
}
