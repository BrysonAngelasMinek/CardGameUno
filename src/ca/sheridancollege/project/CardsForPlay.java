package ca.sheridancollege.project;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryson
 */
public class CardsForPlay extends GroupOfCards {

    private ArrayList<Card> cardPlayer = new ArrayList<>(26);
    private ArrayList<Card> cardAI = new ArrayList<>(26);

    public CardsForPlay(int givenSize) {
        super(givenSize);
    }

    /**
     * @return the cardPlayer
     */
    public ArrayList<Card> getCardPlayer() {
        return cardPlayer;
    }

    /**
     * @param cardPlayer the cardPlayer to set
     */
    public void setCardPlayer(ArrayList<Card> cardPlayer) {
        this.cardPlayer = cardPlayer;
    }

    /**
     * @return the cardAI
     */
    public ArrayList<Card> getCardAI() {
        return cardAI;
    }

    /**
     * @param cardAI the cardAI to set
     */
    public void setCardAI(ArrayList<Card> cardAI) {
        this.cardAI = cardAI;
    }

    public void splitDeck() {
        makeDeck(cards);

        for (int i = 0; i < getSize(); i++) {
            if (i <= 26) {
                getCardPlayer().add(cards.get(i));
            } else {
                getCardAI().add(cards.get(i));
            }
        }
    }
    
    
}
