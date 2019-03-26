package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.prop.Prop;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.BackPackProto;
import com.huyu.protobuf.MessageProto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewCommand extends Command {
    public ViewCommand(String playerName) {
        super(playerName);
    }
    @Override
    public void setType(MessageProto.Message.Builder builder) {
        builder.setType(MessageProto.MSG.View_Req);
    }

    /**
     * 查看背包中的物品
     * 重看装备栏的物品
     * @return
     */
    @Override
    public MessageProto.Message serverExcute() {
        System.out.println("背包");
        Player player = super.getMap().get(super.getPlayerName());
        String[] str = super.getOption();
        byte[] bytes = null;
        MessageProto.Message.Builder builder = MessageProto.Message.newBuilder();
        BackPackProto.BackPack.Builder builder1 = BackPackProto.BackPack.newBuilder();
        builder1.setBackpackId(super.getPlayerName());
        Set<Map.Entry<Integer,Prop>> set = null;
        if("背包".equals(str[0])){
            set = player.getBackpack().entrySet();
            builder1.setType(0);
        }
        if("装备栏".equals(str[0])){
           set = player.getEquipment().entrySet();
            builder1.setType(1);
        }
        for (HashMap.Entry<Integer, Prop> p:set){
            BackPackProto.Prop.Builder builder2 = BackPackProto.Prop.newBuilder();
            builder2.setPropId(p.getValue().getId());
            System.out.println("view" + p.getValue().getId());
            System.out.println("view" + p.getValue().getPropName());
            builder2.setPropName(p.getValue().getPropName());
            builder1.addProp(builder2.build());
        }
        builder.setType(MessageProto.MSG.View_Resp);
        builder.setObj(builder1.build().toByteString());
        return builder.build();
    }
}
