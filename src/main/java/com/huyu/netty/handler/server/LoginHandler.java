package com.huyu.netty.handler.server;

import com.google.protobuf.ByteString;
import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.MessageType;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.CommandReqProto;
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
import java.util.HashMap;
import java.util.Map;

/**
 * 处理登录请求
 */
@ChannelHandler.Sharable
@Component("loginHandler")
public class LoginHandler extends ChannelHandlerAdapter {
    final static Logger logger = LoggerFactory.getLogger(LoginHandler.class);
    @Resource(name = "playerService")
    private PlayerService playerService;
    private Map<String,Player> map;
    private String playerName;
    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("LoginHandler.channelRead()");
        //System.out.println("LoginHandler.channelRead()");
        MessageProto.Message mg = (MessageProto.Message)msg;
        //游戏在线玩家
        OnlinePlayer onlinePlayer = OnlinePlayer.getOnlinePlayer();
        this.map = onlinePlayer.getPlayers();
        System.out.println("Login"+mg.getTypeValue()+"   "+ MessageType.Login_Req);
        //验证是否是登录请求
        if(mg.getTypeValue() == MessageType.Login_Req){
            Player player = new Player();
            PlayerReqProto.PlayerReq playerReq = PlayerReqProto.PlayerReq.parseFrom(mg.getObj());
            System.out.println(playerReq.getPlayerName());
            System.out.println(playerReq.getPsw());
            this.playerName = playerReq.getPlayerName();
            player.setName(playerReq.getPlayerName());
            player.setPassword(playerReq.getPsw());
            String inform = null;
            //检查玩家登录信息
            if(playerService.selectPlayer(player)){
                //加入到在线玩家中
                map.put(player.getName(),player);
                inform = "***************************登陆成功，你已经进入游戏了***************************";
                
            }else{
                inform = "***********************登陆失败，用户名不存在或者密码错误***********************";
            }
            System.out.println("return");
            //返回给客户端消息
            MessageProto.Message.Builder builder1 = MessageProto.Message.newBuilder();
            builder1.setSeq(mg.getSeq()+1);
            builder1.setType(MessageProto.MSG.Login_Resp);
            builder1.setObj(ByteString.copyFrom(inform.getBytes()));
            ctx.writeAndFlush(builder1.build());
        }else{

            CommandReqProto.CommandReq commandReq= CommandReqProto.CommandReq.parseFrom(mg.getObj());
            System.out.println("else " +commandReq.getPlayerName());
            if(map.containsKey(commandReq.getPlayerName())){
                //若已经登录，交给后面的handler处理
                ctx.fireChannelRead(msg);
            }else {
                //若没有登录，返回给客户端未登录信息
                String inform =    "*******************************用户未登陆************************************";
                MessageProto.Message.Builder builder1 = MessageProto.Message.newBuilder();
                builder1.setSeq(mg.getSeq()+1);
                builder1.setType(MessageProto.MSG.Login_Resp);
                builder1.setObj(ByteString.copyFrom(inform.getBytes()));
                ctx.writeAndFlush(builder1.build());
            }
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("LoginHandler.exceptionCaught()");
        System.out.println("LoginHandler.exception()");
        //当发生异常关闭链路时，需要将客户端的信息从注册表删除 保证后续客户端可以重连成功
        this.map.remove(this.playerName);
        cause.printStackTrace();
        ctx.close();
    }

}
