package com.jmsgvn.game.board;

public class CircleBoard extends GameBoard{


    private final char[][] board;

    public CircleBoard() {
        this.board = new char[][]{
                {'#', '-', '@', '@', '-', '#'},
                {'-', '@', '@', '@', '@', '-'},
                {'@', '@', '@', '@', '@', '@'},
                {'@', '@', '@', '@', '@', '@'},
                {'-', '@', '@', '@', '@', '-'},
                {'#', '-', '@', '@', '-', '#'}
        };
    }

    @Override
    public char[][] getBoard() {
        return board;
    }
}
