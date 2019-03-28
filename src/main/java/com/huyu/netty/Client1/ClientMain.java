package com.huyu.netty.Client1;


import com.huyu.netty.handler.client.ClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClientMain {
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private ChannelFuture connect;
    private Bootstrap b;
    private int port;
    private String host;
    private EventLoopGroup group = new NioEventLoopGroup();
    ClientInitializer clientInitializer;

    public ClientInitializer getClientInitializer() {
        return clientInitializer;
    }

    public void setClientInitializer(ClientInitializer clientInitializer) {
        this.clientInitializer = clientInitializer;
    }

    public void start(final int port, final String host) throws Exception {
        // 配置客户端NIO线程组
        this.port = port;
        this.host = host;
        try {
            CountDownLatch latch = new CountDownLatch(1);
            clientInitializer = new ClientInitializer(latch);
            // 客户端辅助启动类 对客户端配置
            b = new Bootstrap();
            b.group(group)//
                    .channel(NioSocketChannel.class)//
                    .option(ChannelOption.TCP_NODELAY, true)//
                    .handler(clientInitializer);//
            // 异步链接服务器 同步等待链接成功

            this.connect();
            System.out.println("********************************已连接到服务器********************************");
            //Channel channel = connect.sync().channel();


            /*
            String data = " Iam clientjjjj...";
            byte[] content = data.getBytes();
            int contentLength = content.length;
            MessageProtocol messageProtocol = new MessageProtocol(contentLength, Signe.ENTER,content);
            f.channel().writeAndFlush(messageProtocol);

            String data1 = " Iam clientjjjj...";
            byte[] content2 = data.getBytes();
            int contentLength3 = content.length;
            MessageProtocol messageProtocol4 = new MessageProtocol(contentLength,Signe.ENTER,content);
            f.channel().writeAndFlush(messageProtocol4);

            */

            new MainPage(this,latch).acceptOrder();

            connect.channel().closeFuture().sync();


        } finally {
            /**
             *   group.shutdownGracefully();
             *   System.out.println("*************************客户端优雅的释放了线程资源...*************************");
             */
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        TimeUnit.SECONDS.sleep(5);
                        try{
                            start(port,host);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    private void connect(){
            this.connect = b.connect(host,port);
    }
    public ChannelFuture getChannelFuture(){
        if(this.connect == null){
            this.connect();
        }
        if(!this.connect.channel().isActive()){
            this.connect();
        }
        return  this.connect;
    }

    public static void main(String[] args) throws Exception {
        new ClientMain().start(8080, "127.0.0.1");

    }

}

