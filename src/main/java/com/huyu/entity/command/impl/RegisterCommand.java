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

public class RegisterCommand extends Command {
    private String pwd;
    public RegisterCommand() {
    }

    public RegisterCommand(String playerName) {
        super(playerName);
    }

    @Override
    public MessageProto.Message excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************************************");
        System.out.println("*********************************进入注册界面*********************************");
        System.out.print("请输入昵称：");
        super.setPlayerName(sc.nextLine());
        String password1;
        while (true){
            System.out.print("请输入密码：");
            password1 = sc.nextLine();
            System.out.print("请重新输入密码：");
            String password2 = sc.nextLine();
            if(password1.equals(password2)==false){
                System.out.println("****************************************************************************");
                System.out.println("*************************两次密码输入不一致，请重新输入*************************");
            }else{
                break;
            }
        }
        this.pwd = password1;
        return super.req();
    }
    @Override
    public void setType(MessageProto.Message.Builder builder){
        builder.setType(MessageProto.MSG.Register_Req);
    }

    @Override
    public void setObj(MessageProto.Message.Builder builder1) {
        PlayerReqProto.PlayerReq.Builder builder = PlayerReqProto.PlayerReq.newBuilder();
        builder.setPlayerName(super.getPlayerName());
        builder.setPsw(pwd);
        builder1.setObj(builder.build().toByteString());
    }
}
