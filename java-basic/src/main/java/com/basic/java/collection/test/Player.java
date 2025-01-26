package com.basic.java.collection.test;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> playerCardList;

    private String name;

    public Player(String name) {
        this.name = name;
        playerCardList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck deck) {
        playerCardList.add(deck.drawCard());
    }

    public void showHand() {
        playerCardList.sort(null);
        System.out.println(name + "의 카드:" + playerCardList + " 합계:" + rankSum());
    }

    public int rankSum() {
        int start = 0;
        for (Card card : playerCardList) {
            start += card.getRank();
        }
        return start;
    }
}
