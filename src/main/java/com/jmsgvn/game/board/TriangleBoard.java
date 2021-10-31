package com.jmsgvn.game.board;

public class TriangleBoard extends GameBoard{

    private final char[][] board;

    public TriangleBoard() {
        this.board = new char[][]{
                {'#', '#', '#', '-', '@', '-', '#', '#', '#'},
                {'#', '#', '-', '@', '@', '@', '-', '#', '#'},
                {'#', '-', '@', '@', '-', '@', '@', '-', '#'},
                {'-', '@', '@', '@', '@', '@', '@', '@', '-'}
        };
    }

    @Override
    public char[][] getBoard() {
        return board;
    }
}
