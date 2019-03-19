package com.huyu.entity.scence;

import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Begin extends Scence implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private static Integer sceneId;
    private final static String sceneName = "启始之地";
    private static ArrayList<Scence> borderScene = new ArrayList<Scence>() ;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Begin begin;
    private Begin() {
        super(borderScene,players,sceneId,sceneName);

    }
    public static Begin getBegin(){
        if(begin == null){
            begin = new Begin();
            borderScene.add(Village.getVillage());
        }
        return begin;
    }

}
