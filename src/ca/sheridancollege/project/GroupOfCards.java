/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private int size;//the size of the grouping
    protected ArrayList<Card> cards = new ArrayList<Card>(getSize());

    public GroupOfCards(int givenSize) {
        size = givenSize;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> showCards() {
        return getCards();
    }

    public void shuffle() {
        Collections.shuffle(getCards());
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @param cards the cards to set
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /*
    Makes a deck of cards that is complety random
     */
    public void makeDeck(ArrayList<Card> card) {

        Random random = new Random();
        Card f = new Card();

        String x;
        String y;
        Card cards;
        int i = 0;

        while (card.size() <= getSize()) {
            x = f.getSuit()[random.nextInt(4)];
            y = f.getValues()[random.nextInt(14)];
            cards = new Card(x, y);
            if (i == 0) {
                card.add(cards);
                i++;
            }

            for (int z = 0; z < card.size(); z++) {
                if (card.get(z).equals(cards) == true) {
                    card.remove(cards);
                }
            }
            card.add(cards);
        }
        setCards(card);

    }

}//end class
