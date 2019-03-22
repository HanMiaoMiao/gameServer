package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;

public class ViewCommand extends Command {
    public ViewCommand(String playerName) {
        super(playerName);
    }

    /**
     * 查看背包中的物品
     * 重看装备栏的物品
     * @return
     */
    @Override
    public MessageProtocol serverExcute() {
        System.out.println("背包");
        Player player = super.getMap().get(super.getPlayerName());
        String[] str = super.getOption();
        byte[] bytes = null;
        if("背包".equals(str[0])){
            bytes = ConvertFunction.toByte(player.getBackpack());
        }
        if("装备栏".equals(str[0])){
            bytes = ConvertFunction.toByte(player.getEquipment());
        }
        return new MessageProtocol(bytes.length, Type.PROP,bytes);
    }
}
