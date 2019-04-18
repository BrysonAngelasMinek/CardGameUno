/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Bryson
 */
public class Statistics extends Player {

    private int WinCount;

    public Statistics(String name) {
        super(name);
    }

    /**
     * @return the WinCount
     */
    public int getWinCount() {
        return WinCount;
    }

    /**
     * @param WinCount the WinCount to set
     */
    public void setWinCount(int WinCount) {
        this.WinCount = WinCount;
    }

    public void saveStats() throws IOException {

        try {
            FileWriter write = new FileWriter("WinData.dat");
            FileReader file = new FileReader("WinData.dat");
            Properties properties = new Properties();

            if (properties.getProperty(this.getPlayerID()).equalsIgnoreCase(properties.getProperty(this.getPlayerID()))) {
                int winCountCatch = this.getWinCount() + Integer.parseInt(properties.getProperty(this.getPlayerID() + "WinCount"));
                properties.load(file);
                properties.remove(this.getPlayerID() + "WinCount");
                properties.setProperty(this.getPlayerID() + "WinCount", Integer.toString(winCountCatch));

            } else {
                properties.setProperty(this.getPlayerID(), Integer.toString(this.getWinCount()));
            }
            properties.store(new FileWriter("WinData.dat", true), "");
        } catch (FileNotFoundException fe) {
            System.out.println("An error has happended OH NO!");
        } catch (IOException io) {
            System.out.println("An error has happended OH NO!");
        } catch (NullPointerException e) {
            Properties properties = new Properties();
            properties.setProperty(this.getPlayerID(), Integer.toString(this.getWinCount()));
            properties.store(new FileWriter("WinData.dat", true), "");
        }

    }

    static public void printStats() throws FileNotFoundException, IOException {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("WinData.dat"));
            properties.forEach((k, v) -> System.out.println("Player: " + k + " Has won: " + v + " games"));
        } catch (FileNotFoundException fe) {
            System.out.println("An error has happended OH NO!");
        } catch (IOException io) {
            System.out.println("An error has happended OH NO!");
        }
    }

}
