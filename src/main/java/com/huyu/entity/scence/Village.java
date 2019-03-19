package com.huyu.entity.scence;

import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Village extends Scence implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private static Integer sceneId;
    private final static String sceneName = "村子";
    private final static ArrayList<Scence> borderScene = new ArrayList<Scence>() ;
    private final static ArrayList<Player> players = new ArrayList<Player>();
    private static Village village;
    private Village() {
        super(borderScene,players,sceneId,sceneName);
    }
    public static Village getVillage(){
        if(village == null){
            village = new Village();
            borderScene.add(Begin.getBegin());
            borderScene.add(Burg.getBurg());
            borderScene.add(Forest.getForest());
        }
        return village;
    }
}
