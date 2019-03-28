package com.huyu.entity.command.impl;

import com.huyu.entity.command.Command;
import com.huyu.protobuf.MessageProto;

public class ExitCommand extends Command {
    public ExitCommand(String playerName) {
        super(playerName);
    }

    @Override
    public void setType(MessageProto.Message.Builder builder) {
        super.setType(builder);
    }
}
