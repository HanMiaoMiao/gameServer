package com.huyu.entity.command.impl;

import com.google.protobuf.ByteString;
import com.google.protobuf.MapEntry;
import com.huyu.entity.Monster;
import com.huyu.entity.NPC;
import com.huyu.entity.Player;
import com.huyu.entity.command.Command;
import com.huyu.entity.scence.OnlinePlayer;
import com.huyu.entity.scence.Scence;
import com.huyu.netty.protocol.MessageProtocol;
import com.huyu.netty.protocol.Type;
import com.huyu.netty.util.ConvertFunction;
import com.huyu.protobuf.*;

import java.util.HashMap;
import java.util.Map;

public class AoiCommand extends Command {
    public AoiCommand(String playerName) {
        super(playerName);
    }
    @Override
    public void setType(MessageProto.Message.Builder builder){
        builder.setType(MessageProto.MSG.Aoi_Req);
    }
    @Override
    public MessageProto.Message serverExcute() {
        System.out.println("aoi Server");
        HashMap<String, Player> map = OnlinePlayer.getOnlinePlayer().getPlayers();
        //由命令执行者得到Player对象
        Player player = map.get(super.getPlayerName());
        //从player中得到玩家当前所在的场景，再得到场景中的玩家
        Scence s = player.getCurrentlyScene();
        MessageProto.Message.Builder builder = MessageProto.Message.newBuilder();
        ScenceRespProto.ScenceResp.Builder builderS = ScenceRespProto.ScenceResp.newBuilder();
        //遍历场景中的NPC
        for (Map.Entry<Integer, NPC> n:s.getNpcs().entrySet()){
            NPCRespProto.NPCResp.Builder builderN = NPCRespProto.NPCResp.newBuilder();
            builderN.setNpcId(n.getValue().getNpcId());
            builderN.setNpcName(n.getValue().getNpcName());
            builderN.setTalk(n.getValue().getTalk());
            builderS.putNpcs(n.getValue().getNpcId(),builderN.build());
        }
        //遍历场景中的Monster
        for (Map.Entry<Integer, Monster> m:s.getMonsters().entrySet()){
            Monster monster = m.getValue();
            MonsterRespProto.MonsterResp.Builder builderM = MonsterRespProto.MonsterResp.newBuilder();
            builderM.setMonsterId(monster.getMonsterId());
            builderM.setMonsterName(monster.getMonsterName());
            builderM.setMonsterBlood(monster.getMonsterBlood());
            builderM.setHarm(monster.getHarm());
            builderS.putMonsters(monster.getMonsterId(),builderM.build());
        }
        //遍历场景中的Player
        for (Map.Entry<String,Player> playerEntry:s.getPlayers().entrySet()){
            PlayerRespProto.PlayerResp.Builder builderP = PlayerRespProto.PlayerResp.newBuilder();
            Player p = playerEntry.getValue();
            builderP.setPlayerId(p.getPlayerId());
            builderP.setPlayerName(p.getPlayerName());
            builderP.setScenceName(p.getCurrentlyScene().getSceneName());
            builderP.setPlayerHp(p.getPlayerHP().getCurrentHP());
            builderP.setPlayerMp(p.getPlayerMp().getCurrentmp());
            builderP.setStatus(p.isStatus());
            builderS.putPlayers(playerEntry.getKey(),builderP.build());
        }
        NPCRespProto.NPCResp.Builder builderN = NPCRespProto.NPCResp.newBuilder();
        builder.setType(MessageProto.MSG.Aoi_Resp);
        builderS.setSceneName(s.getSceneName());
        System.out.println(s.getSceneId());
        if(s.getSceneId()!=null){
            builderS.setSceneId(s.getSceneId());
        }
        builder.setObj(builderS.build().toByteString());
        return builder.build();
    }
}
