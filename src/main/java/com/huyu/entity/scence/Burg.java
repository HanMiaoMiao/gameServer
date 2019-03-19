package com.huyu.entity.scence;

import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Burg extends Scence implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private static Integer sceneId;
    private final static String sceneName = "城堡";
    private static ArrayList<Scence> borderScene = new ArrayList<Scence>() ;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Burg burg;
    private Burg() {
        super(borderScene,players,sceneId,sceneName);

    }
    public static Burg getBurg(){
        if(burg == null){
            burg = new Burg();
            borderScene.add(Village.getVillage());
        }
        return burg;
    }

}
