package com.huyu.netty.handler.server;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
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
import java.util.HashMap;
import java.util.Map;
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
        System.out.println("LoginHandler.channelRead()");
        MessageProtocol mg = (MessageProtocol)msg;
        OnlinePlayer onlinePlayer = OnlinePlayer.getOnlinePlayer();
        HashMap<String,Player> map = onlinePlayer.getPlayers();
        //是否是登陆操作
        if(mg.getSign() == Signe.H2){
            Player player = (Player) ConvertFunction.fromByte(mg.getContent());
            String inform = null;
            if(playerService.selectPlayer(player)){
                //加入到在线玩家中
                map.put(player.getName(),player);
                inform = "     登陆成功，你已经进入游戏了！";
                
            }else{
                inform = "  登陆失败，用户名不存在或者密码错误！";
            }
            byte[] bytes = inform.getBytes();
            MessageProtocol messageProtocol = new MessageProtocol(bytes.length, Type.STRING,bytes);
            ctx.writeAndFlush(messageProtocol);
        }else{
            //不是登陆操作
            System.out.println("其他");
            Command command = (Command)ConvertFunction.fromByte(mg.getContent());
            int cnt = 0;
            for(Map.Entry<String, Player> entry : map.entrySet())
            {
                System.out.println("foreach");
                if(entry.getKey().equals(command.getPlayerName())){
                    ctx.fireChannelRead(msg);
                    cnt=1;
                    break;
                }
            }
            if(cnt==0){
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
