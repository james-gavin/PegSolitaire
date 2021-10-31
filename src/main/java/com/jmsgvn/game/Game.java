package com.jmsgvn.game;

import com.jmsgvn.game.board.*;

import java.util.Scanner;

public class Game {

    private GamePhase gamePhase;
    private GameBoard gameBoard;

    private boolean gameRunning;

    private final Scanner gameScanner;

    public Game() {
        this.gamePhase = GamePhase.SELECTION;
        this.gameScanner = new Scanner(System.in);
        this.gameRunning = true;

        System.out.println(
                """
                WELCOME TO CS300 PEG SOLITAIRE!
                ===============================
                Board Style Menu
                    1) Cross
                    2) Circle
                    3) Triangle
                    4) Simple T
               Choose a board style:\040"""
        );

        gameLoop();
    }

    private void gameLoop() {
        while(gameRunning) {
            switch (gamePhase) {
                case SELECTION -> {
                    String selection = gameScanner.next();

                    this.gamePhase = GamePhase.PLAYING;
                    switch (selection) {
                        case "1" -> this.gameBoard = new CrossBoard();
                        case "2" -> this.gameBoard = new CircleBoard();
                        case "3" -> this.gameBoard = new TriangleBoard();
                        case "4" -> this.gameBoard = new SimpleBoard();
                        default -> {
                            this.gamePhase = GamePhase.SELECTION;
                            System.out.println("This is not a valid game board. Please try again: ");
                        }
                    }
                }

                case PLAYING -> {
                    gameBoard.printBoard();

                    System.out.println("\nChoose the COLUMN of a peg you'd like to move: ");
                    int column = gameScanner.nextInt();

                    System.out.println("Choose the ROW of a peg you'd like to move: ");
                    int row = gameScanner.nextInt();

                    System.out.println("Choose the DIRECTION to move that peg 1) UP, 2) DOWN, 3) LEFT, or 4) RIGHT: ");
                    int direction = gameScanner.nextInt();

                    if(!gameBoard.move(column, row, direction, true)) {
                        System.out.println("You entered an invalid input. Please try again.");
                    }

                    if (gameBoard.countPegsRemaining() == 1) {
                        this.gamePhase = GamePhase.END_WIN;
                        break;
                    }

                    if (gameBoard.countMovesAvailable() == 0) {
                        this.gamePhase = GamePhase.END_LOST;
                    }
                }

                case END_WIN -> {
                    gameBoard.printBoard();
                    System.out.println("You won!");

                    this.gameRunning = false;
                }

                case END_LOST -> {
                    gameBoard.printBoard();
                    System.out.println("You ran out of moves to play. Game over.");

                    this.gameRunning = false;
                }
            }
        }
    }

}