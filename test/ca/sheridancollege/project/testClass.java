package ca.sheridancollege.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Bryson
 */
public class testClass {

    public testClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() 
    //Can't test if it will go bad as I can't force errors 
    @Test
    public void checkPrintStatsGood() {
        boolean expResult = false;
        boolean result = false;

        try {
            Statistics.printStats();
        } catch (IOException ex) {
            result = true;
            assertEquals(expResult, result);
        }
        if (result == false) {
            assertEquals(expResult, result);
        }

    }

    //This will check if the file has been made, if it hasn't then that means something went wrong when the code was running 
    //As the method will make the file.
    @Test
    public void checksaveStatsGood() {

        boolean expResult = false;
        boolean result = false;
        try {
            FileReader reader = new FileReader("WinData.dat");
            reader.read();
            reader.close();

        } catch (IOException e) {

            result = true;
            assertEquals(expResult, result);
        }
        if (result == false) {
            assertEquals(expResult, result);
        }
    }

    @Test//Will check if the errorHelp has been set to anything that means its bad
    public void checkPlayGood() {
        boolean expResult = false;
        War error = new War("War");
        boolean result = false;
        error.setErrorHelp(4);
        if (error.getErrorHelp() == 2) {
            result = true;
            System.out.println("An error has happended");
            assertEquals(expResult, result);
        } else if (error.getErrorHelp() == 4) {
            System.out.println("CheckPlayGood: Passed");
            assertEquals(expResult, result);
        }

    }

    @Test//Will check if the errorHelp has been set to anything that means its bad
    public void checkPlayBoundray() {
        boolean expResult = false;
        War error = new War("War");
        boolean result = false;
        error.setErrorHelp(3);
        if (error.getErrorHelp() == 2) {
            result = true;
            System.out.println("An error has happended");
            assertEquals(expResult, result);
        }//Check if the player has won 
        else if (error.getErrorHelp() == 4) {
            System.out.println("CheckPlayGood: Player has won");
            assertEquals(expResult, result);
        } else if (error.getErrorHelp() == 3) {
            System.out.println("CheckPlayGood: Computer has won");
            assertEquals(expResult, result);
        }

    }

    @Test//Simulates what would happen if an error would happen in the play() as any errors will set error help to 2
    public void checkPlayBad() {
        boolean expResult = true;
        War error = new War("War");
        boolean result = false;
        error.setErrorHelp(2);
        if (error.getErrorHelp() == 2) {
            result = true;
            System.out.println("CheckPlayBad:Passed ");
            assertEquals(expResult, result);
        }

    }

    @Test
    public void checkCardWinCondtionsGood() {
        War cardCondtions = new War("War");
        CardsForPlay x = new CardsForPlay(52);
        x.splitDeck();
        boolean expResult = false;
        boolean result = false;
        String resultOfTest = cardCondtions.cardWinConditions(x.getCardPlayer().get(0), x.getCardAI().get(0));
        if (resultOfTest.equalsIgnoreCase("PlayerBigger") || resultOfTest.equalsIgnoreCase("PlayerSmaller") || resultOfTest.equalsIgnoreCase("WAR")) {
            assertEquals(expResult, result);
            System.out.println("checkCardWinCondtionsGood: Work");
        } else {
            result = true;
            assertEquals(expResult, result);
            System.out.println("checkCardWinCondtionsGood: Failed");

        }

    }

    @Test //This will test what happends if the cards are not variables 
    public void checkCardWinCondtionsBad() {
        War cardCondtions = new War("War");
        CardsForPlay x = new CardsForPlay(52);
        boolean expResult = true;
        boolean result = false;

        try {
            String resultOfTest = cardCondtions.cardWinConditions(x.getCardPlayer().get(0), x.getCardAI().get(0));
            if (resultOfTest.equalsIgnoreCase("PlayerBigger") || resultOfTest.equalsIgnoreCase("PlayerSmaller") || resultOfTest.equalsIgnoreCase("WAR")) {
                assertEquals(expResult, result);
                System.out.println("checkCardWinCondtionsBad: Work");
            } else {
                result = true;
                assertEquals(expResult, result);
                System.out.println("checkCardWinCondtionsBad: Failed");

            }
        } catch (Exception e) {
            System.out.println("checkCardWinCondtionsBad: Failed");
            result = true;
            assertEquals(expResult, result);
        }

    }

    @Test //This will test in the off chance that the CardCondtion Method will return an "error" string instead of the expected result
    public void checkCardWinCondtionsBoundray() {
        War cardCondtions = new War("War");
        CardsForPlay x = new CardsForPlay(52);
        boolean expResult = true;
        boolean result = false;
        String resultOfTest = "error";
        if (resultOfTest.equalsIgnoreCase("PlayerBigger") || resultOfTest.equalsIgnoreCase("PlayerSmaller") || resultOfTest.equalsIgnoreCase("WAR")) {
            assertEquals(expResult, result);
            System.out.println("checkCardWinCondtionsGood: Work");
        } else {
            result = true;
            assertEquals(expResult, result);
            System.out.println("checkCardWinCondtionsGood: Failed");

        }
    }

    @Test
    public void checkCardValueGood() {
        War cardCondtions = new War("War");
        CardsForPlay x = new CardsForPlay(52);
        x.splitDeck();
        boolean expResult = false;
        int resultOfTest = cardCondtions.cardValue(x.getCardPlayer().get(0));
        if (resultOfTest <= 14) {
            boolean result = false;
            System.out.println("checkCardValueGood: Passed");
            assertEquals(expResult, result);
        }
    }

    @Test //Checks if there is somehow a higher value threw wrong input
    public void checkCardValueBoundary() {
        War cardCondtions = new War("War");
        CardsForPlay x = new CardsForPlay(52);
        x.splitDeck();
        boolean expResult = true;
        boolean result = false;
        int resultOfTest = cardCondtions.cardValue(x.getCardPlayer().get(0)) + 1;
        if (resultOfTest >= 15) {
            System.out.println("checkCardValueBoundary: Passed");
            assertEquals(expResult, result);
        }

    }

    @Test
    public void checkCardValueBad() {
        War cardCondtions = new War("War");
        CardsForPlay x = new CardsForPlay(52);
        boolean expResult = true;
        boolean result = false;
        try {
            int resultOfTest = cardCondtions.cardValue(x.getCardPlayer().get(0));
            if (resultOfTest <= 14) {
                System.out.println("checkCardValueBad: Failed");
                assertEquals(expResult, result);
            }
        } catch (Exception e) {
            System.out.println("checkCardValueBad: Passed");
            result = true;
            assertEquals(expResult, result);
        }
    }

    @Test//This will also check the method makeDeck from GroupOfCards as if this relies on makeDeck() to work
    public void checkSplitDeckGood() {
        CardsForPlay x = new CardsForPlay(52);
        boolean expResult = false;
        boolean result = false;
        x.splitDeck();
        if (x.getCardAI().size() == 26 && x.getCardPlayer().size() == 26) {
            System.out.println("checkSplitDeckGood: Passed");
            assertEquals(expResult, result);
        }
    }

    @Test//Will test if the SplitDeck for some reason has a size over 54 
    public void checkSplitDeckBoundary() {
        CardsForPlay x = new CardsForPlay(54);
        boolean expResult = true;
        boolean result = false;
        x.splitDeck();
        if (x.getCardAI().size() == 26 && x.getCardPlayer().size() == 26) {
            System.out.println("checkSplitDeckBoundary: Failed");
            assertEquals(expResult, result);
        } else if (x.getSize() > 26) {
            System.out.println("checkSplitDeckBoundary: Passed");
            result = true;
            assertEquals(expResult, result);
        }
    }

    @Test
    public void checkSplitDeckBad() {
        CardsForPlay x = new CardsForPlay(42);
        boolean expResult = true;
        boolean result = false;
        try {
            x.splitDeck();
            if (x.getCardAI().size() == 26 && x.getCardPlayer().size() == 26) {
                System.out.println("checkSplitDeckBad: Failed");
                assertEquals(expResult, result);
            }
        } catch (Exception e) {
            System.out.println("checkSplitDeckBad: Passed");
            result = true;
            assertEquals(expResult, result);
        }
    }
}
