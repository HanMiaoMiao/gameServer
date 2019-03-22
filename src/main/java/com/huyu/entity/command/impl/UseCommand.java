package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.prop.Prop;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;

public class UseCommand extends Command {
    public UseCommand(String playerName) {
        super(playerName);
    }

    /**
     *
     * @return
     */
    @Override
    public MessageProtocol serverExcute() {
        Player player = super.getMap().get(super.getPlayerName());
        String[] str = super.getOption();
        //从玩家背包中拿出道具
        Prop prop = player.getBackpack().get(Integer.parseInt(str[0]));
        String msg = prop.effect(player);
        return new MessageProtocol(msg.getBytes().length, Type.STRING,msg.getBytes());
    }
}
