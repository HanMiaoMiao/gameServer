package com.huyu.netty.handler.server;

import com.huyu.entity.command.Command;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.util.ConvertFunction;
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
        MessageProtocol mg = (MessageProtocol)msg;
        byte[] bytes = mg.getContent();
        Command command = (Command) ConvertFunction.fromByte(bytes);
        //多态执行不同的命令，得到命令返回值
        MessageProtocol m = command.serverExcute();

        ctx.channel().writeAndFlush(m);
    }
}
