package com.huyu.entity.command;

import com.huyu.entity.command.impl.AoiCommand;
import com.huyu.entity.command.impl.LoginCommand;
import com.huyu.entity.command.impl.MoveCommand;
import com.huyu.entity.command.impl.RegisterCommand;

public class CommandFactory {
    public static Command creator(String[] split,String playerName){
        Command command ;
        if(split.length==1){
            switch (split[0]){
                case "register": {
                    command = new RegisterCommand();
                    command.setCommandName("register");
                    command.setCommandSign(CommandSign.REGIST);
                    return command;

                }
                case "login":{
                    command = new LoginCommand();
                    command.setCommandName("login");
                    command.setCommandSign(CommandSign.LOGIN);
                    return command;
                }
                case "aoi":{
                    command = new AoiCommand(playerName);
                    command.setCommandName("aoi");
                    command.setCommandSign(CommandSign.AOI);
                    return command;
                }
                case "exit":{
                    return null;
                }
                default:
                    System.out.println("************************************");
                    System.out.println("指令错误！");
                    System.out.println("************************************");
                    return null;
            }

        }
        if(split.length==2){
            command = new MoveCommand(playerName);
            command.setCommandName("move");
            command.setCommandSign(CommandSign.MOVE);
            command.setOption(split[1]);
            return command;
        }
        return null;
    }
}
