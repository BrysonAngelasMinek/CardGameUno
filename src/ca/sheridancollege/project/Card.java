/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author Bryson Minek, 2019
 */
 public class Card {
    //default modifier for child classes

    private final String[] Suit = {"Hearts", "Spades", "Clubs", "Diamonds"};
    private final String[] Values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "King", "Queen", "Jack", "Ace", "Joker"};
    private String cardSuit;
    private String cardValue;
    
    public Card() {
        
    }
    
    public Card(String cardSuit, String cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    /**
     * @return the cardSuit
     */
    public String getCardSuit() {
        return cardSuit;
    }

    /**
     * @param cardSuit the cardSuit to set
     */
    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    /**
     * @return the cardValue
     */
    public String getCardValue() {
        return cardValue;
    }

    /**
     * @param cardValue the cardValue to set
     */
    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public String[] getSuit() {
        return Suit;
    }

    public String[] getValues() {
        return Values;
    }
    
    @Override
    public boolean equals(Object a){
        Card card = (Card) a;
        if(this.getCardSuit().equalsIgnoreCase(card.getCardSuit()) == true && this.getCardValue().equalsIgnoreCase(card.getCardValue()) == true){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return cardSuit + ":" + cardValue;
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    

}
