package com.huyu.entity.command.impl;

import com.huyu.entity.NPC;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;

import java.util.HashMap;

public class SpeakCommand extends Command {
    public SpeakCommand(String playerName) {
        super(playerName);
    }
    @Override
    public MessageProtocol serverExcute() {
        String[] str = super.getOption();
        Scence s = super.getMap().get(super.getPlayerName()).getCurrentlyScene();
        HashMap<Integer, NPC> npcMap = (HashMap<Integer, NPC>) s.getNpcs();
        String talk = npcMap.get(Integer.parseInt(str[0])).getTalk();
        MessageProtocol msg = new MessageProtocol(talk.getBytes().length, Type.STRING,talk.getBytes());
        return msg;
    }

}
