package com.kenneth.model.yugioh;

import java.lang.reflect.Modifier;

import static com.kenneth.model.yugioh.MonsterMod.*;

public abstract class Monster {
    String name;
    Short level = 1;
    Short atk = 0;
    Short def = 0;
    public final MonsterMod modifier = new MonsterMod(this);
    public Monster(String name){
        this.name=name;
    }
    public Monster(String name, short lv, short a, short d){
        this.name = name;
        level = lv;
        atk = a;
        def = d;
    }
    public String name(){return name;}
    public final short level(){return level;}
    public final short atk(){return atk;}
    public final short def(){return def;}
}
