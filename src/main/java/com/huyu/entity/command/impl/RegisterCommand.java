package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.util.ConvertFunction;

import java.util.Scanner;

public class RegisterCommand extends Command {
    public RegisterCommand() {
    }

    public RegisterCommand(String playerName) {
        super(playerName);
    }

    @Override
    public MessageProtocol excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("*************进入注册界面*************");
        System.out.print("请输入昵称：");
        String name = sc.nextLine();
        String password1;
        while (true){
            System.out.print("请输入密码：");
            password1 = sc.nextLine();
            System.out.print("请重新输入密码：");
            String password2 = sc.nextLine();
            if(password1.equals(password2)==false){
                System.out.println("************************************");
                System.out.println("**两次密码输入不一致，请重新输入！！！**");
            }else{
                break;
            }
        }
        Player player = new Player();
        player.setName(name);
        player.setPassword(password1);
        byte[] bytes = ConvertFunction.toByte(player);
        MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Signe.H1,bytes);
        return messageProtocol;
    }

    @Override
    public MessageProtocol serverExcute() {
        return null;
    }
}
