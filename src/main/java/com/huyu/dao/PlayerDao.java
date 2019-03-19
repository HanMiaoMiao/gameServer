package com.huyu.dao;

import com.huyu.pojo.Player;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("playerDao")
@Scope("prototype")
public interface PlayerDao {
    //找到玩家
    Player findByName(@Param("playerName")String playerName);
    int addPlayer(Player player);
    int deletePlayerByName(String playerName);
    int updatePlayer(Player player);
}
