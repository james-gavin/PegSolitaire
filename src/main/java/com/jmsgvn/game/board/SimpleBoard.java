package com.jmsgvn.game.board;

public class SimpleBoard extends GameBoard{

    private final char[][] board;

    public SimpleBoard() {
        this.board = new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '@', '@', '@', '-'},
                {'-', '-', '@', '-', '-'},
                {'-', '-', '@', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };
    }

    @Override
    public char[][] getBoard() {
        return board;
    }
}
