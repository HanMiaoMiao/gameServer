package com.huyu.netty.handler.server;

import com.huyu.netty.decoder.MessageDecoder;
import com.huyu.netty.encoder.MessageEncoder;

import com.huyu.service.Register;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {



    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginHandler loginHandler = (LoginHandler)context.getBean("loginHandler") ;
        RegisterHandler registerHandler =(RegisterHandler) context.getBean("registerHandler");
        socketChannel.pipeline()
                //编码
                .addLast(new MessageEncoder())
                .addLast(new MessageDecoder())
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
