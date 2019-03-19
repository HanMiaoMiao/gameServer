package com.huyu.entity.scence;

import com.huyu.entity.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class Forest extends Scence implements Serializable {
    private static final long  SerialVersionUID = 1L;
    private static Integer sceneId;
    private final static String sceneName = "森林";
    private static ArrayList<Scence> borderScene = new ArrayList<Scence>() ;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Forest forest;
    private Forest() {
        super(borderScene,players,sceneId,sceneName);

    }
    public static Forest getForest(){
        if(forest == null){
            forest = new Forest();
            borderScene.add(Village.getVillage());
        }
        return forest;
    }

}
