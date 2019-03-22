package com.huyu.entity.command;

import com.huyu.entity.Player;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.util.ConvertFunction;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Command implements Serializable{
    private static final long  SerialVersionUID = 1L;
    /**
     * 命令类型
     */
    private int commandSign;
    /**
     * 执行者
     */
    private String playerName;
    /**
     * 命令名称
     */
    private String commandName;
    /**
     * 命令参数
     */
    private String[] option;


    public Command() {
    }

    public Command(String playerName) {
       this.playerName = playerName;
    }

    /**
     * 封装客户端的命令
     * @return
     */
    public MessageProtocol excute() {
        byte[] bc = ConvertFunction.toByte(this);
        MessageProtocol messageProtocol = new MessageProtocol(bc.length, Signe.H3,bc);
        return messageProtocol;
    }

    /**
     * 执行客户端的命令
     * @return
     */
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

    public String[] getOption() {
        return option;
    }

    public void setOption(String[] option) {
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

    public HashMap<String, Player> getMap() {

        return OnlinePlayer.getOnlinePlayer().getPlayers();
    }


}
