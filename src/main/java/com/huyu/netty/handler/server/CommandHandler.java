package com.huyu.netty.handler.server;

import com.google.protobuf.ProtocolStringList;
import com.huyu.entity.command.Command;
import com.huyu.entity.command.impl.*;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.MessageType;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.CommandReqProto;
import com.huyu.protobuf.MessageProto;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理其它的命令
 */
public class CommandHandler extends ChannelHandlerAdapter {
    final static Logger logger = LoggerFactory.getLogger(CommandHandler.class);

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("CommandHandler.exceptionCaught()");
        System.out.println("CommandHandler.exceptionCaught()");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("CommandHandler.channelRead()");
        System.out.println("CommandHandler.channelRead()");
        MessageProto.Message mg = (MessageProto.Message)msg;
        CommandReqProto.CommandReq commandReq = CommandReqProto.CommandReq.parseFrom(mg.getObj());
        String[] str = new String[commandReq.getOptionCount()];
        for(int i = 0; i < str.length; i++){
            str[i] = commandReq.getOption(i);
            System.out.println(str[i]);
        }
        Command cm =  null;
        switch (mg.getTypeValue()) {
            case MessageType.Move_Req: {
                cm = new MoveCommand(commandReq.getPlayerName());
                break;
            }
            case MessageType.Aoi_Req: {
                cm = new AoiCommand(commandReq.getPlayerName());
                break;
            }
            case MessageType.Attack_Req: {
                cm = new AttackCommand(commandReq.getPlayerName());
                break;
            }
            case MessageType.Speak_Req: {
                cm = new SpeakCommand(commandReq.getPlayerName());
                break;
            }
            case MessageType.Use_Req: {
                cm = new UseCommand(commandReq.getPlayerName());
                break;
            }
            case MessageType.View_Req: {
                cm = new ViewCommand(commandReq.getPlayerName());
                break;
            }
        }
        cm.setOption(str);
        MessageProto.Message m = cm.serverExcute();
        ctx.channel().writeAndFlush(m);
    }
}
