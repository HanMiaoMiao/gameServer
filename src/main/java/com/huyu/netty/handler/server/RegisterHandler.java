package com.huyu.netty.handler.server;

import com.google.protobuf.ByteString;
import com.huyu.entity.Player;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.MessageType;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.MessageProto;
import com.huyu.protobuf.PlayerReqProto;
import com.huyu.service.PlayerService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 处理注册请求
 */
@Component("registerHandler")
@ChannelHandler.Sharable
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
        MessageProto.Message mg = (MessageProto.Message)msg;
        //System.out.println(mg.getSign());
        //System.out.println(Signe.H1);
        //验证是否是注册请求
        System.out.println("Register"+mg.getTypeValue()+"   "+ MessageType.Register_Req);
        if(mg.getTypeValue()== MessageType.Register_Req){
            //在service设置玩家的信息
            Player player = new Player();
            PlayerReqProto.PlayerReq playerReq = PlayerReqProto.PlayerReq.parseFrom(mg.getObj());
            player.setName(playerReq.getPlayerName());
            player.setPassword(playerReq.getPsw());
            String inform = null;
            //service检查用户名是否重复，若没有重复，则添加玩家信息到数据库，返回给客户端
            if(playerService.addPlayer(player)) {
                inform = "            注册成功!";

            }else{
                inform = "注册失败，用户名重复，请输入指令重新注册";
            }
            MessageProto.Message.Builder builder = MessageProto.Message.newBuilder();
            builder.setSeq(mg.getSeq()+1);
            builder.setType(MessageProto.MSG.Login_Resp);
            builder.setObj(ByteString.copyFromUtf8(inform));
            ctx.writeAndFlush(builder.build());
            System.out.println(builder.build());
        }else{
            //不是登录请求，交给后面的handler处理
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
