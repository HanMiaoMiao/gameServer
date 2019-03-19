package com.huyu.netty.handler.client;

import com.huyu.netty.protocol.MessageProtocol;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
@ChannelHandler.Sharable
public class ClientHandler extends ChannelHandlerAdapter {
    final static Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    private CountDownLatch lathc;
    private MessageProtocol result;

    public ClientHandler(CountDownLatch lathc) {
        this.lathc = lathc;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //System.out.println("***********已连接到服务器*************");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            logger.info("ClientHandler.channelRead()");
            //System.out.println("ClientHandler.channelRead()");
            result = (MessageProtocol) msg;
            lathc.countDown();
        }finally {
            ReferenceCountUtil.release(msg);
        }

    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("ClientHandler.exceptionCaught()");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //System.out.println("ClientHandler.channelReadComplete()");
        //ctx.close();
    }

    public void resetLatch(CountDownLatch initLathc){
        this.lathc = initLathc;
    }
    public MessageProtocol getResult() {
        return result;
    }
}
