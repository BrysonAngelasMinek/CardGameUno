/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryson
 */
public class War extends Game {

    private Statistics player;
    private int errorHelp;

    public War(String givenName) {
        super(givenName);
    }

    @Override
    public void play() {
        CardsForPlay x = new CardsForPlay(52);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like your playerID to be?");
        player = new Statistics(keyboard.nextLine());
        x.splitDeck();
        //  System.out.println("To play the game just read the output and press the key S to place a card down"
        //        + "at any time in the game you can hit esc and bring up options");
        while (x.getCardPlayer().size() != 0) {
            if (x.getCardPlayer().size() == 0) {
                declareLosser();
                errorHelp = 3;
                break;
            } else if (x.getCardAI().size() == 0) {
                declareWinner();
                player.setWinCount(1);
                errorHelp = 4;
                try {
                    player.saveStats();
                } catch (IOException ex) {
                    Logger.getLogger(War.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            System.out.println("Press any key to place a card");
            String input = keyboard.nextLine();
            if (input != null) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + "Your Card:" + x.getCardPlayer().get(0).toString());
                System.out.println("Computers Card:" + x.getCardAI().get(0).toString());
                if (cardWinConditions(x.getCardPlayer().get(0), x.getCardAI().get(0)).equalsIgnoreCase("PlayerBigger")) {
                    x.getCardPlayer().add(x.getCardPlayer().size() - 1, x.getCardAI().get(0)); //Adds the card the Player won from the AI to bottom of players deck
                    x.getCardPlayer().add(x.getCardPlayer().size() - 2, x.getCardPlayer().get(0)); //Adds the card the Player just used to the bottom of the deck
                    x.getCardPlayer().remove(0); //Removes the card from the current postion in the arraylist since it was just used
                    x.getCardAI().remove(0); //Removes the card from the computers deck since they lost it
                    System.out.println("You have won this small battle and stole the enemies cards to use against them");
                } else if (cardWinConditions(x.getCardPlayer().get(0), x.getCardAI().get(0)).equalsIgnoreCase("PlayerSmaller")) {
                    //Since player lost the card will be remvoed from the deck and added to the bottom of the computers deck
                    /*
                    Will probably turn this into a method at a later time just currently want to see the logic
                     */
                    x.getCardAI().add(x.getCardAI().size() - 1, x.getCardPlayer().get(0)); //Adds the card the AI won from player to computers deck
                    x.getCardAI().add(x.getCardAI().size() - 2, x.getCardAI().get(0)); //Adds the card the AI just used to the bottom of the deck 
                    x.getCardAI().remove(0); //Removes the card from the current postion in the arraylist since it was just used 
                    x.getCardPlayer().remove(0); //Removes the card from the players deck since they lost it 
                    System.out.println("You have lost this small battle but don't worry you can still win the war");
                } else if (cardWinConditions(x.getCardPlayer().get(0), x.getCardAI().get(0)).equalsIgnoreCase("WAR!")) {
                    War(x);
                } else {
                    System.out.println("You have gotten an error please Restart the program");
                    System.exit(100);
                    errorHelp = 2;
                }

            } else {
                System.out.println("You have not pressed any key I don't know how but still please press a key");
            }
        }

    }

    public String cardWinConditions(Card cardPlay, Card cardComp) {
        int playerValue = cardValue(cardPlay);
        int compValue = cardValue(cardComp);
        if (playerValue > compValue) {
            return "PlayerBigger";
        } else if (playerValue < compValue) {
            return "PlayerSmaller";
        } else if (playerValue == compValue) {
            return "WAR!";

        } else {
            errorHelp = 2;
            return "Error";

        }

    }

    /*
    This will take a card and change the string to a assigned int value  
     */
    public int cardValue(Card realValue) {
        int value = 0;

        if (realValue.getCardValue().equalsIgnoreCase("ACE")) {
            value = 14;
        } else if (realValue.getCardValue().equalsIgnoreCase("KING")) {
            value = 13;

        } else if (realValue.getCardValue().equalsIgnoreCase("QUEEN")) {
            value = 12;

        } else if (realValue.getCardValue().equalsIgnoreCase("JACK")) {
            value = 11;
        } else {
            value = Integer.parseInt(realValue.getCardValue());
        }

        return value;
    }

    /**
     * @param errorHelp the errorHelp to set
     */
    public void setErrorHelp(int errorHelp) {
        this.errorHelp = errorHelp;
    }

    /**
     * @return the errorHelp
     */
    public int getErrorHelp() {
        return errorHelp;
    }

    /*
    Logic for the logic of war where it takes the variable and puts out 5 cards 
    and if won will give whoever won all the cards
     */
    public CardsForPlay War(CardsForPlay deck) {
        Scanner keyboard = new Scanner(System.in);
        String input = null;

        //If the deck is almost empty it will use this if statement instead to help prvent errors
        if (deck.getCardPlayer().size() <= 6) {
            System.out.println("You are almost out of cards you must take your last stand the rest of your cards are going to fight");
            for (int i = 0; i < deck.getCardPlayer().size(); i++) {
                System.out.println("Your Card: " + deck.getCardPlayer().get(i).toString());
                System.out.println("Computers Card:" + deck.getCardAI().get(i).toString());
            }
            if (cardWinConditions(deck.getCardPlayer().get(deck.getCardPlayer().size() - 1), deck.getCardAI().get(deck.getCardAI().size() - 1)).equalsIgnoreCase("PlayerBigger")) {
                for (int i = 0; i <= deck.getCardPlayer().size() - 1; i++) {
                    deck.getCardPlayer().add(deck.getCardPlayer().size() - 1, deck.getCardAI().get(0)); //Adds the card the Player won from the AI to bottom of players deck
                    deck.getCardPlayer().add(deck.getCardPlayer().size() - 2, deck.getCardPlayer().get(0)); //Adds the card the Player just used to the bottom of the deck
                    deck.getCardPlayer().remove(0); //Removes the card from the current postion in the arraylist since it was just used
                    deck.getCardAI().remove(0); //Removes the card from the computers deck since they lost it
                    if (deck.getCardPlayer().size() == 0 || deck.getCardAI().size() == 0) {
                        break;
                    }
                }
                System.out.println("You have won the battle! Now try to win the war");
            } else if (cardWinConditions(deck.getCardPlayer().get(deck.getCardPlayer().size() - 1), deck.getCardAI().get(deck.getCardAI().size() - 1)).equalsIgnoreCase("PlayerSmaller")) {
                for (int i = 0; i <= deck.getCardPlayer().size() - 1; i++) {
                    deck.getCardAI().add(deck.getCardAI().size() - 1, deck.getCardPlayer().get(0)); //Adds the card the AI won from player to computers deck
                    deck.getCardAI().add(deck.getCardAI().size() - 2, deck.getCardAI().get(0)); //Adds the card the AI just used to the bottom of the deck 
                    deck.getCardAI().remove(0); //Removes the card from the current postion in the arraylist since it was just used 
                    deck.getCardPlayer().remove(0); //Removes the card from the players deck since they lost it 
                    if (deck.getCardPlayer().size() == 0 || deck.getCardAI().size() == 0) {
                        break;
                    }
                }
                System.out.println("You have lost the battle. Not all is lost you can still win the war");
            } else if (cardWinConditions(deck.getCardPlayer().get(deck.getCardPlayer().size() - 1), deck.getCardAI().get(deck.getCardAI().size() - 1)).equalsIgnoreCase("WAR")) {
                System.out.println("Get READY TO BATTLE!");
                War(deck);
            }
        } //The conditonal for when the deck.getCardAI is equal to or lower than 5 
        else if (deck.getCardAI().size() <= 6) {
            System.out.println("The enemy is almost out of cards they are taking a last stand you have them on the ropes");
            for (int i = 0; i < deck.getCardAI().size(); i++) {
                System.out.println("Your Card: " + deck.getCardPlayer().get(i).toString());
                System.out.println("Computers Card:" + deck.getCardAI().get(i).toString());
            }
            if (cardWinConditions(deck.getCardPlayer().get(deck.getCardPlayer().size() - 1), deck.getCardAI().get(deck.getCardAI().size() - 1)).equalsIgnoreCase("PlayerBigger")) {
                for (int i = 0; i <= deck.getCardAI().size() - 1; i++) {
                    deck.getCardPlayer().add(deck.getCardPlayer().size() - 1, deck.getCardAI().get(0)); //Adds the card the Player won from the AI to bottom of players deck
                    deck.getCardPlayer().add(deck.getCardPlayer().size() - 2, deck.getCardPlayer().get(0)); //Adds the card the Player just used to the bottom of the deck
                    deck.getCardPlayer().remove(0); //Removes the card from the current postion in the arraylist since it was just used
                    deck.getCardAI().remove(0); //Removes the card from the computers deck since they lost it
                    if (deck.getCardPlayer().size() == 0 || deck.getCardAI().size() == 0) {
                        break;
                    }
                }
                System.out.println("You have won the battle! Now try to win the war");
            } else if (cardWinConditions(deck.getCardPlayer().get(deck.getCardPlayer().size() - 1), deck.getCardAI().get(deck.getCardAI().size() - 1)).equalsIgnoreCase("PlayerSmaller")) {
                for (int i = 0; i <= deck.getCardAI().size() - 1; i++) {
                    deck.getCardAI().add(deck.getCardAI().size() - 1, deck.getCardPlayer().get(0)); //Adds the card the AI won from player to computers deck
                    deck.getCardAI().add(deck.getCardAI().size() - 2, deck.getCardAI().get(0)); //Adds the card the AI just used to the bottom of the deck 
                    deck.getCardAI().remove(0); //Removes the card from the current postion in the arraylist since it was just used 
                    deck.getCardPlayer().remove(0); //Removes the card from the players deck since they lost it 
                    if (deck.getCardPlayer().size() == 0 || deck.getCardAI().size() == 0) {
                        break;
                    }
                }
                System.out.println("You have lost the battle. Not all is lost you can still win the war");
            } else if (cardWinConditions(deck.getCardPlayer().get(5), deck.getCardAI().get(5)).equalsIgnoreCase("WAR")) {
                System.out.println("Get READY TO BATTLE!");
                War(deck);
            }
        } else {
            System.out.println("Press any key 5 times to place 4 cards as troops and 1 leader. Highest Leader wins");
            for (int i = 1; i < 6; i++) {
                input = keyboard.nextLine();
                System.out.println("Your Card:" + deck.getCardPlayer().get(i).toString());
                System.out.println("Computers Card:" + deck.getCardAI().get(i).toString());
            }
            if (input != null) {

                if (cardWinConditions(deck.getCardPlayer().get(5), deck.getCardAI().get(5)).equalsIgnoreCase("PlayerBigger")) {
                    for (int i = 0; i <= 5; i++) {
                        deck.getCardPlayer().add(deck.getCardPlayer().size() - 1, deck.getCardAI().get(0)); //Adds the card the Player won from the AI to bottom of players deck
                        deck.getCardPlayer().add(deck.getCardPlayer().size() - 2, deck.getCardPlayer().get(0)); //Adds the card the Player just used to the bottom of the deck
                        deck.getCardPlayer().remove(0); //Removes the card from the current postion in the arraylist since it was just used
                        deck.getCardAI().remove(0); //Removes the card from the computers deck since they lost it
                        if (deck.getCardPlayer().size() == 0 || deck.getCardAI().size() == 0) {
                            break;
                        }
                    }
                    System.out.println("You have won the battle! Now try to win the war");
                } else if (cardWinConditions(deck.getCardPlayer().get(5), deck.getCardAI().get(5)).equalsIgnoreCase("PlayerSmaller")) {
                    for (int i = 0; i <= 5; i++) {
                        deck.getCardAI().add(deck.getCardAI().size() - 1, deck.getCardPlayer().get(0)); //Adds the card the AI won from player to computers deck
                        deck.getCardAI().add(deck.getCardAI().size() - 2, deck.getCardAI().get(0)); //Adds the card the AI just used to the bottom of the deck 
                        deck.getCardAI().remove(0); //Removes the card from the current postion in the arraylist since it was just used 
                        deck.getCardPlayer().remove(0); //Removes the card from the players deck since they lost it 
                        if (deck.getCardPlayer().size() == 0 || deck.getCardAI().size() == 0) {
                            break;
                        }
                    }
                    System.out.println("You have lost the battle. Not all is lost you can still win the war");
                } else {
                    System.out.println("Get READY TO BATTLE!");
                    Collections.shuffle(deck.getCardAI());
                    Collections.shuffle(deck.getCardPlayer());
                    War(deck);
                }

            }
        }

        return deck;
    }

    @Override
    public void declareWinner() {
        JOptionPane.showMessageDialog(null, "You have WON THE GAME! CONGRATULATIONS");
    }

    @Override
    public void declareLosser() {
        JOptionPane.showMessageDialog(null, "What a shame you have lost the game. Please play again");
    }

}
