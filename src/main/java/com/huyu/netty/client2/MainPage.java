package com.huyu.netty.client2;

import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.command.CommandFactory;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.handler.client.ClientInitializer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.util.ConvertFunction;
import io.netty.channel.ChannelFuture;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MainPage {
    private CountDownLatch latch;
    private ClientInitializer clientInitializer;
    private ClientMain clientMain;

    public MainPage(ClientMain clientMain, CountDownLatch latch) {
        this.clientMain = clientMain;
        this.clientInitializer = clientMain.clientInitializer;
        this.latch = latch;
    }

    //接受指令
    public  void acceptOrder() throws ClassNotFoundException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String playerName = null;
        while(true){
            System.out.print("请输入指令：");
            String command = sc.nextLine();
            String[] split = command.split("<|>");
            Command command1 = CommandFactory.creator(split,playerName);
            if(command1 == null){
                continue;
            }
            MessageProtocol messageProtocol = command1.excute();
            if(split[0].equals("login")){
                byte[] bytes = messageProtocol.getContent();
                Player player = (Player) ConvertFunction.fromByte(bytes);
                playerName = player.getName();
            }
            //同步处理请求
            //System.out.println("同步处理请求");
            //System.out.println(messageProtocol);
            this.sycRequest(messageProtocol);
            //System.out.println("tb");
        }
    }
    //同步处理请求
    public void sycRequest(MessageProtocol messageProtocol) throws InterruptedException, ClassNotFoundException {
        ChannelFuture connect = clientMain.getChannelFuture();
        //System.out.println(connect.channel());
        //System.out.println(messageProtocol);
        //System.out.println(connect);
        connect.channel().writeAndFlush(messageProtocol);
        //System.out.println(connect.channel());
        latch.await();
        //System.out.println(" latch.await()");
        MessageProtocol result = clientInitializer.getServerResult();
        //System.out.println(result.getSign());
        switch (result.getSign()){
            case 1:this.string(result);break;
            case 2:this.player(result);break;
            case 3:this.scence(result);break;
        }
        this.setLatch(new CountDownLatch(1));
        clientInitializer.resetLathc(this.getLatch());
    }
    //处理响应
    //字符串响应
    public void string(MessageProtocol result){
        //System.out.println("string");
        byte[] bytes = result.getContent();
        System.out.println("************************************");
        System.out.println(new String(bytes));
        System.out.println("************************************");
    }
    //玩家
    public void player(MessageProtocol result) throws ClassNotFoundException {
        //System.out.println(result);
        ArrayList<Player> players = (ArrayList<Player>) ConvertFunction.fromByte(result.getContent());
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("   你当前所在的场景是："+ players.get(0).getCurrentlyScene().getSceneName());
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("*********该场景中还有其他人物**********");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("+++\t\t昵称\t\t\t"+"生存状态 \t\t ++++");
        for (Player p:
                players) {
            System.out.println("+++\t\t"+p.getName()+"\t\t\t"+(p.isStatus()==1?"生存":"死亡")+"    \t\t ++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
    //场景
    public void scence(MessageProtocol result) throws ClassNotFoundException {
        Scence scence = (Scence) ConvertFunction.fromByte(result.getContent());
        System.out.println("************************************");
        System.out.println("         你已到达："+scence.getSceneName());
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("*********该场景中还有其他人物：********");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("+++\t\t昵称\t\t\t"+"生存状态 \t\t ++++");
        for (Player p:
                scence.getPlayers()) {
            System.out.println("+++\t\t"+p.getName()+"\t\t\t"+(p.isStatus()==1?"生存":"死亡")+"    \t\t ++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
    public CountDownLatch getLatch() {
        return latch;
    }
    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
    public ClientInitializer getClientInitializer() {
        return clientInitializer;
    }
    public void setClientInitializer(ClientInitializer clientInitializer) {
        this.clientInitializer = clientInitializer;
    }
}