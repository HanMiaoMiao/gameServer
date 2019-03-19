package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;

import java.util.HashMap;

public class AoiCommand extends Command {
    public AoiCommand(String playerName) {
        super(playerName);
    }

    @Override
    public MessageProtocol excute() {
        //System.out.println("excute");
        byte[] bc = ConvertFunction.toByte(this);
        MessageProtocol messageProtocol = new MessageProtocol(bc.length, Signe.H3,bc);
        return messageProtocol;
    }

    @Override
    public MessageProtocol serverExcute() {
        //System.out.println("serverExcute");
        HashMap<String, Player> map = OnlinePlayer.getOnlinePlayer().getPlayers();
        Player player = map.get(super.getPlayerName());
        byte[] bytes = ConvertFunction.toByte(player.getCurrentlyScene().getPlayers());
        MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Type.PLAYER,bytes);
        //System.out.println(messageProtocol);
        return messageProtocol;
    }
}
