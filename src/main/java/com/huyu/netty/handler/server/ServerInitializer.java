package com.huyu.netty.handler.server;

import com.huyu.netty.decoder.MessageDecoder;
import com.huyu.netty.encoder.MessageEncoder;
import com.huyu.protobuf.MessageProto;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class ServerInitializer extends ChannelInitializer<SocketChannel> {
     public static ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("ServerInitializer:"+CONTEXT);
        System.out.println(new ClassPathXmlApplicationContext("applicationContext.xml"));
        //加载spring容器
        LoginHandler loginHandler = (LoginHandler)CONTEXT.getBean("loginHandler") ;
        RegisterHandler registerHandler =(RegisterHandler) CONTEXT.getBean("registerHandler");
        socketChannel.pipeline()
                //编码
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageProto.Message.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                //.addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                //.addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                //.addLast(new UserDecoder())
                //.addLast(new StringDecoder())
                .addLast("registerHandler",registerHandler)
                .addLast("loginHandler",loginHandler)
                .addLast(new CommandHandler());
                //.addLast(new LoginHandler());
    }

}
