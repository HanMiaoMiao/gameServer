package com.huyu.entity.command;

import com.huyu.entity.command.impl.*;

public class CommandFactory {
    public static Command creator(String[] split, String playerName){
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
                    command = new ExitCommand(playerName);
                    command.setCommandName("exit");
                    return command;
                }
                default:
                    System.out.println("****************************************************************************");
                    System.out.println("***********************************指令错误**********************************");
                    System.out.println("****************************************************************************");
                    return null;
            }

        }
        if(split.length==2){
            switch (split[0]){
                case "move":{
                    command = new MoveCommand(playerName);
                    command.setCommandName("move");
                    command.setCommandSign(CommandSign.MOVE);
                    String[] str = {split[1]};
                    command.setOption(str);
                    command.setOption(str);
                    return command;
                }
                case "aoi":{
                    command = new AoiCommand(playerName);
                    command.setCommandName("aoi");
                    String[] str = {split[1]};
                    command.setOption(str);
                    command.setCommandSign(CommandSign.AOI);
                    return command;
                }
                case "use":{
                    command = new UseCommand(playerName);
                    command.setCommandName("use");
                    String[] str = {split[1]};
                    command.setOption(str);
                    command.setCommandSign(CommandSign.USE);
                    return command;
                }
                case "view":{
                    command = new ViewCommand(playerName);
                    command.setCommandName("view");
                    String[] str = {split[1]};
                    command.setOption(str);
                    command.setCommandSign(CommandSign.VIEW);
                    return command;
                }
                default:
                    System.out.println("****************************************************************************");
                    System.out.println("***********************************指令错误**********************************");
                    System.out.println("****************************************************************************");
                    return null;
            }
        }
        if(split.length==4){
            switch (split[0]){
                case "speak":{
                    command = new SpeakCommand(playerName);
                    command.setCommandName("speak");
                    String[] str = {split[1],split[3]};
                    command.setOption(str);
                    command.setCommandSign(CommandSign.SPEAK);
                    return command;
                }
                case "attack":{
                    command = new AttackCommand(playerName);
                    command.setCommandName("attack");
                    String[] str = {split[1],split[3]};
                    command.setOption(str);
                    command.setCommandSign(CommandSign.ATTACK);
                    return command;
                }
                default:
                    System.out.println("****************************************************************************");
                    System.out.println("***********************************指令错误**********************************");
                    System.out.println("****************************************************************************");
                    return null;
            }
        }
        return null;
    }
}
