package com.huyu.entity.command.impl;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.util.ConvertFunction;

import java.util.Scanner;

public class LoginCommand extends Command {
    public LoginCommand() {
    }

    public LoginCommand(String playerName){
        super(playerName);
    }
    @Override
    public MessageProtocol excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("************************************");
        System.out.print("请输入昵称：");
        String name = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();
        Player player = new Player();
        player.setName(name);
        player.setPassword(password);
        byte[] bytes = ConvertFunction.toByte(player);
        MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Signe.H2,bytes);
        return messageProtocol;
    }

    @Override
    public MessageProtocol serverExcute() {
        return null;
    }
}
