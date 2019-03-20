package com.huyu.netty.handler.server;

import com.huyu.netty.decoder.MessageDecoder;
import com.huyu.netty.encoder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
     public static ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //加载spring容器
        LoginHandler loginHandler = (LoginHandler)CONTEXT.getBean("loginHandler") ;
        RegisterHandler registerHandler =(RegisterHandler) CONTEXT.getBean("registerHandler");
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
