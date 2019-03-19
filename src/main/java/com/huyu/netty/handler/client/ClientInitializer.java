package com.huyu.netty.handler.client;

import com.huyu.netty.decoder.MessageDecoder;
import com.huyu.netty.encoder.MessageEncoder;
import com.huyu.netty.protocol.MessageProtocol;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

import java.util.concurrent.CountDownLatch;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    private ClientHandler clientHandler;
    private CountDownLatch latch;
    public ClientInitializer(CountDownLatch latch){
        this.latch =latch;
    }
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        clientHandler = new ClientHandler(latch);
        socketChannel.pipeline()
                //.addLast(new UserEncoder())
                //.addLast(new StringEncoder())
                .addLast("messageDecoder",new MessageDecoder())
                .addLast("messageEncoder",new MessageEncoder())
                .addLast("clientHandler",clientHandler);
                //.addLast("clientHandler",new com.huyu.netty.handler.clientHandler.ClientHandler())
                //.addLast("scanceHandler",new ScenceHandler())
                //.addLast("stringHandler",new StringHandler())
                //.addLast("moveHandler",new MoveHandler());
    }
    public MessageProtocol getServerResult(){
        return clientHandler.getResult();
    }
    //重置同步锁
    public void resetLathc(CountDownLatch initLathc){
        clientHandler.resetLatch(initLathc);
    }
}
