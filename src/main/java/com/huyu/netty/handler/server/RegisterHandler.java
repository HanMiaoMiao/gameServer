package com.huyu.netty.handler.server;

import com.huyu.entity.Player;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.service.PlayerService;
import com.huyu.service.impl.PlayerServiceImpl;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("registerHandler")
public class RegisterHandler  extends ChannelHandlerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(RegisterHandler.class);
    @Resource(name = "playerService")
    private PlayerService playerService ;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接到服务器");
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("RegisterHandler.channelRead()");
        System.out.println("RegisterHandler.channelRead()");
        MessageProtocol mg = (MessageProtocol)msg;
        System.out.println(mg.getSign());
        System.out.println(Signe.H1);
        if(mg.getSign()== Signe.H1){
            //在service设置玩家的信息
            Player player = (Player) ConvertFunction.fromByte(mg.getContent());
            String inform = null;
            if(playerService.addPlayer(player)) {
                inform = "            注册成功!";

            }else{
                inform = "注册失败，用户名重复，请输入指令重新注册";
            }
            byte[] bytes = inform.getBytes();
            MessageProtocol response = new MessageProtocol(bytes.length, Type.STRING, bytes);
            ctx.writeAndFlush(response);
            System.out.println(response);
        }else{
            ctx.fireChannelRead(msg);
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("RegisterHandler.exceptionCaught()");
        System.out.println("RegisterHandler.exceptionCaught()");
        cause.printStackTrace();
        ctx.close();
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("读完毕");
        //ctx.close();
    }
}
