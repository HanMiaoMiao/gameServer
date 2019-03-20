package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;

import java.util.HashMap;

public class AoiCommand extends Command {
    public AoiCommand(String playerName) {
        super(playerName);
    }

    @Override
    public MessageProtocol serverExcute() {
        HashMap<String, Player> map = OnlinePlayer.getOnlinePlayer().getPlayers();
        //由命令执行者得到Player对象
        Player player = map.get(super.getPlayerName());
        //从player中得到玩家当前所在的场景，再得到场景中的玩家
        byte[] bytes = ConvertFunction.toByte(player.getCurrentlyScene());
        //
        MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Type.SCENCE,bytes);
        //System.out.println(messageProtocol);
        return messageProtocol;
    }
}
