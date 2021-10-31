package com.jmsgvn;

import com.jmsgvn.game.Game;

import java.util.Scanner;


public class PegSolitaire {


    public static void main(String[] args) {
        boolean wantsToContinue = true;

        while (wantsToContinue) {
            new Game();

            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWould you like to play again? (Y/N)");

            String response = scanner.next();
            if (!response.equalsIgnoreCase("y")) {
                wantsToContinue = false;
                System.out.println("\nThanks for playing. Goodbye!");
            }
        }
    }
}
