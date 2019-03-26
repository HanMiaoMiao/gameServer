package com.huyu.entity.command.impl;

import com.google.protobuf.ByteString;
import com.huyu.entity.NPC;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.protobuf.MessageProto;

import java.util.HashMap;

public class SpeakCommand extends Command {
    public SpeakCommand(String playerName) {
        super(playerName);
    }
    @Override
    public void setType(MessageProto.Message.Builder builder) {
        builder.setType(MessageProto.MSG.Speak_Req);
    }

    @Override
    public MessageProto.Message serverExcute() {
        String[] str = super.getOption();
        Scence s = super.getMap().get(super.getPlayerName()).getCurrentlyScene();
        HashMap<Integer, NPC> npcMap = (HashMap<Integer, NPC>) s.getNpcs();
        String talk = npcMap.get(Integer.parseInt(str[0])).getTalk();
        MessageProto.Message.Builder builder = MessageProto.Message.newBuilder();
        builder.setType(MessageProto.MSG.Speak_Resp);
        builder.setObj(ByteString.copyFromUtf8(talk));
        return builder.build();
    }

}
