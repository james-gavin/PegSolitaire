package com.jmsgvn.game.board;

public abstract class GameBoard {

    public GameBoard() {

    }

    public abstract char[][] getBoard();

    public void printBoard() {

        StringBuilder stringBoard = new StringBuilder();

        stringBoard.append("  ");

        for (int topRow = 1; topRow <= getBoard()[0].length; topRow++) {
            stringBoard.append(topRow).append(" ");
        }

        stringBoard.append("\n");

        for (int row = 0; row < getBoard().length; row++) {
            stringBoard.append(row + 1).append(" ");
            for (int column = 0; column < getBoard()[row].length; column++) {
                stringBoard.append(getBoard()[row][column]).append(" ");
            }
            stringBoard.append("\n");
        }

        System.out.println(stringBoard);
    }

    public char whatIsHere(int column, int row) {
        try {
            return getBoard()[row-1][column-1];
        } catch (Exception e) {
            return '0';
        }
    }

    public boolean updatePosition(int column, int row, char value) {
        try {
            getBoard()[row-1][column-1] = value;
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean move(int column, int row, int direction, boolean isPlayer) {

        // 1 = up 2 = down 3 = left 4 = right

        char selectedPosition = whatIsHere(column, row);

        if (selectedPosition == '0' || selectedPosition == '-' || selectedPosition == '#') {
            return false;
        }

        int landingColumn = column;
        int landingRow = row;

        int inBetweenColumn = column;
        int inBetweenRow = row;

        switch (direction) {
            case 1:
                landingRow = row - 2;
                inBetweenRow = row - 1;
                break;
            case 2:
                landingRow = row + 2;
                inBetweenRow = row + 1;
                break;
            case 3:
                landingColumn = column - 2;
                inBetweenColumn = column - 1;
                break;
            case 4:
                landingColumn = column + 2;
                inBetweenColumn = column + 1;
                break;
            default:
                return false;
        }

        char landingPosition = whatIsHere(landingColumn, landingRow);
        char inBetweenPosition = whatIsHere(inBetweenColumn, inBetweenRow);

        if (landingPosition != '-') {
            return false;
        }

        if (inBetweenPosition != '@') {
            return false;
        }

        if (isPlayer) {
            updatePosition(column, row, '-');
            updatePosition(landingColumn, landingRow, '@');
            updatePosition(inBetweenColumn, inBetweenRow, '-');
        }

        return true;
    }

    public int countPegsRemaining() {
        int pegs = 0;

        for (int row = 0; row < getBoard().length; row++) {
            for (int column = 0; column < getBoard()[row].length; column++) {
                if (getBoard()[row][column] == '@') {
                    pegs++;
                }
            }
        }

        return pegs;
    }

    public int countMovesAvailable() {
        int moves = 0;

        for (int row = 0; row < getBoard().length; row++) {
            for (int column = 0; column < getBoard()[row].length; column++) {
                for (int direction = 1; direction <= 4; direction++) {
                    if (move(column+1, row+1, direction, false)) {
                        moves++;
                    }
                }
            }
        }

        return moves;
    }

}
