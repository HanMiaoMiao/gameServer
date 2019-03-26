package com.huyu.entity.command;

import com.google.protobuf.ByteString;
import com.huyu.entity.Player;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.MessageType;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.CommandReqProto;
import com.huyu.protobuf.MessageProto;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Command implements Serializable{
    private static final long  SerialVersionUID = 1L;
    private int seq = 1;
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
    public MessageProto.Message excute() {
        return req();
    }

    /**
     * 执行客户端的命令
     * @return
     */
    public MessageProto.Message serverExcute(){
        return null;
    }

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

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
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

    public MessageProto.Message req(){
        MessageProto.Message.Builder builder =  MessageProto.Message.newBuilder();
        //设置消息序列号
        builder.setSeq(seq++);
        //ByteString.copyFrom() 将protobuf的 ByteString 转为 java byte[]
        setObj(builder);
        setType(builder);
        return builder.build();
    }

    /**
     * 设置消息类型
     * @param builder
     */
    public void setType(MessageProto.Message.Builder builder){
        builder.setType(MessageProto.MSG.Command_Req);
    }

    /**
     * 设置传输的对象
     * @param builder1
     */
    public void setObj(MessageProto.Message.Builder builder1){
        CommandReqProto.CommandReq.Builder builder = CommandReqProto.CommandReq.newBuilder();
        builder.setCommandName(this.commandName);
        if(this.playerName!=null){
            builder.setPlayerName(this.playerName);
        }
        builder.setCommandSign(MessageType.Command_Req);
        if (this.option!=null){
            List<String> str = Arrays.asList(this.option);
            builder.addAllOption(str);
        }
        builder1.setObj(builder.build().toByteString());
    }

}
