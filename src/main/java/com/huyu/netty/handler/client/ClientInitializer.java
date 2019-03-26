package com.huyu.netty.handler.client;

import com.huyu.netty.decoder.MessageDecoder;
import com.huyu.netty.encoder.MessageEncoder;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.protobuf.MessageProto;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

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
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageProto.Message.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast("clientHandler",clientHandler);
                //.addLast("clientHandler",new com.huyu.netty.handler.clientHandler.ClientHandler())
                //.addLast("scanceHandler",new ScenceHandler())
                //.addLast("stringHandler",new StringHandler())
                //.addLast("moveHandler",new MoveHandler());
    }
    public MessageProto.Message getServerResult(){
        return clientHandler.getResult();
    }
    //重置同步锁
    public void resetLathc(CountDownLatch initLathc){
        clientHandler.resetLatch(initLathc);
    }
}
