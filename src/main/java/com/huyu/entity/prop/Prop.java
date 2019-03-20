package com.huyu.entity.prop;

import com.huyu.entity.Player;

import java.io.Serializable;

/**
 * 道具
 */
public abstract class Prop implements Serializable {
    private static final long  SerialVersionUID = 1L;
    public abstract String effect(Player player);
}
