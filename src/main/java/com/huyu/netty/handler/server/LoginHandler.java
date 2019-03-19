package com.huyu.netty.handler.server;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Signe;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.service.PlayerService;
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
@Component("loginHandler")
public class LoginHandler extends ChannelHandlerAdapter {
    final static Logger logger = LoggerFactory.getLogger(LoginHandler.class);
    @Resource(name = "playerService")
    private PlayerService playerService;

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
        MessageProtocol mg = (MessageProtocol)msg;
        //游戏在线玩家
        OnlinePlayer onlinePlayer = OnlinePlayer.getOnlinePlayer();
        HashMap<String,Player> map = onlinePlayer.getPlayers();
        //验证是否是登录请求
        if(mg.getSign() == Signe.H2){
            Player player = (Player) ConvertFunction.fromByte(mg.getContent());
            String inform = null;
            //检查玩家登录信息
            if(playerService.selectPlayer(player)){
                //加入到在线玩家中
                map.put(player.getName(),player);
                inform = "     登陆成功，你已经进入游戏了！";
                
            }else{
                inform = "  登陆失败，用户名不存在或者密码错误！";
            }
            //返回给客户端消息
            byte[] bytes = inform.getBytes();
            MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Type.STRING,bytes);
            ctx.writeAndFlush(messageProtocol);
        }else{
            //不是登录操作
            Command command = (Command)ConvertFunction.fromByte(mg.getContent());
            if(map.containsKey(command.getPlayerName())){
                //若已经登录，交给后面的handler处理
                ctx.fireChannelRead(msg);
            }else {
                //若没有登录，返回给客户端未登录信息
                byte[] bytes = "用户未登陆".getBytes();
                MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Type.STRING,bytes);
                ctx.writeAndFlush(messageProtocol);
            }
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("LoginHandler.exceptionCaught()");
        System.out.println("LoginHandler.exception()");
        cause.printStackTrace();
        ctx.close();
    }

}
