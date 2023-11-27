package com.kenneth.service;

import com.kenneth.model.yugioh.*;
import com.kenneth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("getCards")
public class BuyDeck implements AcquireCards {
    private CardGroup cards;
    public BuyDeck(){
        System.out.println("BuyDeck service created...");
    }
    public BuyDeck(CardGroup cards){
        System.out.println("BuyDeck service created with cards...");
        this.cards = cards;
    }
    @Override
    public Monster[] getMonsters(){
        return cards.getMonsters();
    }

    @Autowired
    public void setCards(CardGroup cards) {
        System.out.println("BuyDeck is set with cards...");
        this.cards = cards;
    }
}
