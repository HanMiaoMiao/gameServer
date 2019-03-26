package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.MessageType;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.CommandReqProto;
import com.huyu.protobuf.MessageProto;
import com.huyu.protobuf.PlayerReqProto;

import java.util.Scanner;

public class LoginCommand extends Command {
    private String pwd;
    public LoginCommand() {
    }

    public LoginCommand(String playerName){
        super(playerName);
    }

    /**
     * login请求
     * @return
     */
    @Override
    public MessageProto.Message excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************************************");
        System.out.print("请输入昵称：");
        super.setPlayerName(sc.nextLine());
        System.out.print("请输入密码：");
        pwd = sc.nextLine();
        return super.req();
    }
    @Override
    public void setType(MessageProto.Message.Builder builder){
        builder.setType(MessageProto.MSG.Login_Req);
    }


    @Override
    public void setObj(MessageProto.Message.Builder builder1) {
        PlayerReqProto.PlayerReq.Builder builder = PlayerReqProto.PlayerReq.newBuilder();
        builder.setPlayerName(this.getPlayerName());
        builder.setPsw(pwd);
        builder1.setObj(builder.build().toByteString());
    }
}
