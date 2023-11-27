package com.kenneth.model.yugioh;

import java.util.function.BiFunction;

public class MonsterMod {
    public enum Stat {
        ATK, DEF, LEVEL, RANK
    }
    public enum Modification{
        ADD, MULTIPLY
    }
    private Monster mon;
    public MonsterMod(Monster mon){
        this.mon=mon;
    }
    public void modifyStat(Stat stat, Modification op, int value){
        switch(stat){
            case ATK:
                if(op == Modification.ADD)
                    mon.atk = (short)(value + mon.atk);
                else
                    mon.atk = (short)(value * mon.atk);
                break;
            case DEF:
                if(op == Modification.ADD)
                    mon.def = (short)(value+mon.def);
                else
                    mon.def = (short)(value*mon.def);
                break;
        }
    }
}