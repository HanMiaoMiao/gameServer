package com.huyu.entity.command.impl;

import com.google.protobuf.ByteString;
import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.prop.Prop;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.protobuf.MessageProto;

public class UseCommand extends Command {
    public UseCommand(String playerName) {
        super(playerName);
    }
    @Override
    public void setType(MessageProto.Message.Builder builder) {
        builder.setType(MessageProto.MSG.Use_Req);
    }

    /**
     *
     * @return
     */
    @Override
    public MessageProto.Message serverExcute() {
        System.out.println("use server");
        Player player = super.getMap().get(super.getPlayerName());
        String[] str = super.getOption();
        //从玩家背包中拿出道具

        Prop prop = player.getBackpack().get(Integer.parseInt(str[0]));
        String msg;
        if (prop!=null){
            msg= prop.effect(player);
        }else {
            msg = "背包中没有该道具";
        }

        MessageProto.Message.Builder builder = MessageProto.Message.newBuilder();
        builder.setType(MessageProto.MSG.Login_Resp);
        builder.setObj(ByteString.copyFrom(msg.getBytes()));
        return builder.build();
    }
}
