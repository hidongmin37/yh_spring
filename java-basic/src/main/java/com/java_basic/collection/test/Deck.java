package com.java_basic.collection.test;

import java.util.*;

public class Deck {
    private List<Card> cardList = new ArrayList<>();

    public Deck() {
        initCard();
        shuffle();
    }

    private void initCard() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                cardList.add(new Card(i, suit));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(cardList);
    }

    public Card drawCard() {
        return cardList.remove(0);
    }





}
