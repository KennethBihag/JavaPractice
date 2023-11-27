package com.kenneth.repository;

import com.kenneth.model.yugioh.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.DataOutput;
import java.time.Instant;
import java.util.*;
import java.util.function.*;

@Repository("deck")
public class Deck implements CardGroup {
    private static int max = 10;
    private Monster[] monsters = new Monster[max];
    public Random random = new Random(Instant.now().getEpochSecond());
    public Deck(){
        for(int i=0;i<max;++i){
            UUID randomName = new UUID(random.nextLong(),random.nextLong());
            String name = randomName.toString();
            short lv = (short)(random.nextInt(12)+1);
            Function<Random,Short> calc = r-> (short)(r.nextInt(5000)+1);
            short atk = calc.apply(random);
            short def = calc.apply(random);
            monsters[i] = new Normal(name,lv,atk,def);
        }
    }
    public Monster[] getMonsters(){
        return monsters;
    }
    @Autowired
    public void voidMethod(int i){
        System.out.println("Deck: void method invoked...");
    }
}
