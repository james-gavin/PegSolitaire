package com.jmsgvn.game.board;

public class CrossBoard extends GameBoard{

    private final char[][] board;

    public CrossBoard() {
        this.board = new char[][]{
                {'#', '#', '#', '@', '@', '@', '#', '#', '#'},
                {'#', '#', '#', '@', '@', '@', '#', '#', '#'},
                {'@', '@', '@', '@', '@', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '-', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '@', '@', '@', '@', '@'},
                {'#', '#', '#', '@', '@', '@', '#', '#', '#'},
                {'#', '#', '#', '@', '@', '@', '#', '#', '#'}
        };
    }

    @Override
    public char[][] getBoard() {
        return board;
    }
}
