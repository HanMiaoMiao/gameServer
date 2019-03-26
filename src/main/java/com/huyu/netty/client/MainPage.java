package com.huyu.netty.client;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.StringValue;
import com.huyu.entity.Monster;
import com.huyu.entity.NPC;
import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.command.CommandFactory;
import com.huyu.entity.prop.Prop;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.handler.client.ClientInitializer;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.MessageType;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.*;
import io.netty.channel.ChannelFuture;

import java.util.*;
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
    public  void acceptOrder() throws ClassNotFoundException, InterruptedException, InvalidProtocolBufferException {
        Scanner sc = new Scanner(System.in);
        String playerName = null;
        while(true){
            System.out.println("****************************************************************************");
            System.out.print("请输入指令：");
            String command = sc.nextLine();
            String[] split = command.split("<|>");
            Command command1 = CommandFactory.creator(split,playerName);
            if(command1 == null){
                continue;
            }
            MessageProto.Message msg = command1.excute();
            if(split[0].equals("login")){
                PlayerReqProto.PlayerReq playerReq = PlayerReqProto.PlayerReq.parseFrom(msg.getObj());
                playerName = playerReq.getPlayerName();
            }
            //同步处理请求
            //System.out.println("同步处理请求");
            //System.out.println(messageProtocol);
            this.sycRequest(msg);
            //System.out.println("tb");
        }
    }
    //同步处理请求
    public void sycRequest(MessageProto.Message messageProtocol) throws InterruptedException, ClassNotFoundException, InvalidProtocolBufferException {
        ChannelFuture connect = clientMain.getChannelFuture();
        //System.out.println(connect.channel());
        //System.out.println(messageProtocol);
        //System.out.println(connect);
        connect.channel().writeAndFlush(messageProtocol);
        //System.out.println(connect.channel());
        latch.await();
        //System.out.println(" latch.await()");
        MessageProto.Message result = clientInitializer.getServerResult();
        //System.out.println(result.getSign());
        switch (result.getTypeValue()){
            case MessageType.Login_Resp: string(result);break;
            case MessageType.Register_Resp:string(result);break;
            case MessageType.Move_Resp:string(result);break;
            case MessageType.Aoi_Resp:scence(result);break;
            case MessageType.Attack_Resp:attack(result);break;
            case MessageType.Use_Req:string(result);break;
            case MessageType.Speak_Resp:string(result);break;
            case MessageType.View_Resp:view(result);
        }
        this.setLatch(new CountDownLatch(1));
        clientInitializer.resetLathc(this.getLatch());
    }

    private void attack(MessageProto.Message result) throws InvalidProtocolBufferException {
        AttackRespProto.AttackResp attackResp = AttackRespProto.AttackResp.parseFrom(result.getObj());
        MonsterRespProto.MonsterResp monsterResp = attackResp.getMonster();
        PlayerRespProto.PlayerResp playerResp = attackResp.getPlayer();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++\t怪物ID"+"\t\t"+"怪物名称"+"\t\t"+"怪物剩余血量"+"\t"+"怪物生存状态"+"\t"+"怪物伤害值"+"  \t\t  ++++");
        System.out.println("++++\t"+monsterResp.getMonsterId()+"\t\t"+monsterResp.getMonsterName()+"\t\t"+monsterResp.getMonsterBlood()+"\t"+(monsterResp.getStatus()?"生存":"死亡")+"\t\t\t"+monsterResp.getHarm()+"\t\t\t\t  ++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++\t玩家ID"+"\t"+"玩家名称"+"\t"+"玩家剩余血量"+"\t"+"玩家剩余魔法"+"\t"+"玩家生存状态"+"\t"+"伤害值"+"\t\t  ++++");
        System.out.println("++++\t"+playerResp.getPlayerId()+"\t\t\t"+playerResp.getPlayerName()+"\t\t"+playerResp.getPlayerHp()+"\t\t"+playerResp.getPlayerMp()+"\t\t"+(playerResp.getStatus()==1?"生存":"死亡")+"\t\t\t"+playerResp.getHarm()+"\t\t\t  ++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private void view(MessageProto.Message result) throws InvalidProtocolBufferException {
        BackPackProto.BackPack backPack = BackPackProto.BackPack.parseFrom(result.getObj());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if(backPack.getType()==0){
            System.out.println("+++++++++++++++++++++++++++++++"+backPack.getBackpackId()+"的背包++++++++++++++++++++++++++++++++++++++");
        }
        if(backPack.getType()==1){
            System.out.println(backPack.getBackpackId()+"的装备栏");
            System.out.println("++++++++++++++++++++++++++++++"+backPack.getBackpackId()+"的装备栏++++++++++++++++++++++++++++++++++++++");
        };
        List<BackPackProto.Prop> props = backPack.getPropList();

        System.out.println("++++    装备ID"+"\t\t\t\t\t\t\t"+"装备名称"+"\t\t\t\t\t\t\t  ++++");
        for (BackPackProto.Prop p: props) {
            System.out.println("++++    "+p.getPropId()+"\t\t\t\t\t\t\t\t"+p.getPropName()+"\t\t\t\t\t\t\t\t  ++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    //处理响应
    //字符串响应
    public void string(MessageProto.Message result) throws InvalidProtocolBufferException {
        String str = new String(result.getObj().toByteArray());
        System.out.println("****************************************************************************");
        System.out.println(str);
    }

    //场景
    public void scence(MessageProto.Message result) throws ClassNotFoundException, InvalidProtocolBufferException {
        ScenceRespProto.ScenceResp scence = ScenceRespProto.ScenceResp.parseFrom(result.getObj());
        System.out.println("****************************************************************************");
        System.out.println("***************************你当前所在的场景是："+scence.getSceneName()+"*************************");
        System.out.println("****************************************************************************");
        System.out.println("****************************************************************************");
        System.out.println("*******************************该场景中还有其他实体****************************");
        System.out.println("****************************************************************************");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++\t\t玩家名\t\t\t\t\t\t\t"+"生存状态 \t\t\t\t\t\t\t  ++++");
        for(Map.Entry<String, PlayerRespProto.PlayerResp> entry: scence.getPlayersMap().entrySet())
        {   PlayerRespProto.PlayerResp p = entry.getValue();
            System.out.println("+++\t\t"+p.getPlayerName()+"\t\t\t\t\t\t\t\t"+(p.getStatus()==1?"生存":"死亡")+"\t\t\t\t\t\t\t\t  ++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++\t\t\tnpcID\t\t\t\t\t\t\t"+"npcName\t\t\t\t\t\t  ++++");
        for(Map.Entry<Integer, NPCRespProto.NPCResp> entry: scence.getNpcsMap().entrySet())
        {   NPCRespProto.NPCResp p = entry.getValue();
            System.out.println("+++\t\t\t"+p.getNpcId()+"\t\t\t\t\t\t\t\t"+p.getNpcName()+"\t\t\t\t\t\t  ++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++\t\tmonsterID\t\t"+"monsterName\t\t"+"生存状态 \t\t"+"monsterBlood"+"\t\t  ++++");
        for(Map.Entry<Integer, MonsterRespProto.MonsterResp> entry: scence.getMonstersMap().entrySet())
        {   MonsterRespProto.MonsterResp p = entry.getValue();
            System.out.println("+++\t\t"+p.getMonsterId()+"\t\t\t"+p.getMonsterName()+"\t\t"+(p.getStatus()==false?"生存":"死亡")+"\t\t\t"+p.getMonsterBlood()+"\t\t\t\t  ++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
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