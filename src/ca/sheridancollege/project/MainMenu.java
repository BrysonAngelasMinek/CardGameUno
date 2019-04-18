/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Bryson
 */
public class MainMenu {

    public static void main(String args[]) throws IOException {
        War ar = new War("War");
        System.out.println("1. Play Game");
        System.out.println("2. View Statistics Of Games");
        System.out.println("3. Exit The Program");
        System.out.println("\n\n\n" + "Please Enter corrosponding number of the menu item you would like to activate");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("1")) {
            War game = new War("War");
            game.play();
        } else if (userInput.equalsIgnoreCase("2")) {
            Statistics.printStats();
        } else if(userInput.equalsIgnoreCase("3")){
            System.exit(1);
        }else{
            System.out.println("Please select one of the numbers above");
        }
    }
}
