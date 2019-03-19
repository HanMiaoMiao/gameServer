package com.huyu.entity.command;

import com.huyu.netty.protocol.MessageProtocol;

import java.io.Serializable;

public abstract class Command implements Serializable{
    private static final long  SerialVersionUID = 1L;
    private int commandSign;
    private String playerName;
    private String commandName;
    private String option;


    public Command() {
    }

    public Command(String playerName) {
       this.playerName = playerName;
    }

    public abstract MessageProtocol excute()  ;
    public abstract MessageProtocol serverExcute() ;

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getCommandSign() {
        return commandSign;
    }

    public void setCommandSign(int commandSign) {
        this.commandSign = commandSign;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
