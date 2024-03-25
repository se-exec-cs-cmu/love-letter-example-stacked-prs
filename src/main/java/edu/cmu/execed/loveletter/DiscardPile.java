package edu.cmu.execed.loveletter;

import java.util.ArrayList;

public class DiscardPile {
    private ArrayList<Card> cards;

    public DiscardPile() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public int value() {
        int value = 0;
        for (Card c : this.cards) {
            value += c.value();
        }
        return value;
    }

    public void clear() {
        this.cards.clear();
    }

    public void print() {
        for (Card c : this.cards) {
            System.out.println(c);
        }
    }
}
