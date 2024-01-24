import java.util.Scanner;
public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String [][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String playerOne = "";
        String playerTwo = "";
        boolean gameDone = false;
        boolean done = false;
        boolean doneRound = false;
        boolean donePlayerOne = false;
        boolean donePlayerTwo = false;
        int playerOneMoveRow = -1;
        int playerOneMoveCol = -1;
        int playerTwoMoveRow = -1;
        int playerTwoMoveCol = -1;
        String temp;
        clearBoard();
        while (!gameDone) {
            System.out.println("Welcome to TicTacToe!");
            while (!done) {
                temp = InputHelper.getNonZeroLenString(scan, "Player 1, choose X or O");
                if (temp.equalsIgnoreCase("X")) {
                    playerOne = "X";
                    playerTwo = "O";
                    done = true;
                } else if (temp.equalsIgnoreCase("O")) {
                    playerOne = "O";
                    playerTwo = "X";
                    done = true;
                } else {
                    System.out.println("Invalid");
                }
            }
            clearBoard();
            showBoard();
            while (!doneRound) {
                donePlayerOne = false;
                donePlayerTwo = false;
                while (!donePlayerOne){
                    playerOneMoveRow = InputHelper.getRangedInt(scan, "Player One, pick a row for your move", 1, 3);
                    playerOneMoveCol = InputHelper.getRangedInt(scan, "Player One, pick a column for your move", 1, 3);
                    if (isValidMove(playerOneMoveRow - 1, playerOneMoveCol - 1)) {
                        donePlayerOne = true;
                    } else {
                        System.out.println("That move is already taken");
                    }
                }
                board[playerOneMoveRow -1][playerOneMoveCol -1] = playerOne;
                showBoard();
                if (isWin(playerOne) || isTie()) {
                    doneRound = true;
                    break;
                }
                while (!donePlayerTwo){
                    playerTwoMoveRow = InputHelper.getRangedInt(scan, "Player Two, pick a row for your move", 1, 3);
                    playerTwoMoveCol = InputHelper.getRangedInt(scan, "Player Two, pick a column for your move", 1, 3);
                    if (isValidMove(playerTwoMoveRow - 1, playerTwoMoveCol - 1)) {
                        donePlayerTwo = true;
                    } else {
                        System.out.println("That move is already taken");
                    }
                }
                board[playerTwoMoveRow -1][playerTwoMoveCol -1] = playerTwo;
                showBoard();
                if (isWin(playerTwo) || isTie()) {
                    doneRound = true;
                    break;
                }
            }

            if (isWin(playerOne)) {
                System.out.println("Player One Wins!");
            } else if (isWin(playerTwo)) {
                System.out.println("Player Two Wins!");
            } else if (isTie()) {
                System.out.println("You Tied!");
            }

            gameDone = InputHelper.getYNConfirm(scan, "Would you like to play again?(Y/N)");
        }

        }


    private static void showBoard(){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + "  ");
            }
            System.out.println();
        }
    }
    private static void clearBoard(){
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board [r][c] = "-";
            }
        }
    }
    private static boolean isValidMove(int row, int col){
        boolean valid = false;
        if (board[row][col] == "-") {
            valid = true;
        }
        return valid;
    }

    private static boolean isRowWin(String player){
        boolean rowValid = false;
        int counter = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c].equals(player)) {
                    counter++;
                }
            }
            if (counter == 3) {
                rowValid = true;
            }
            counter = 0;
        }
        return rowValid;
    }
    private static boolean isColWin(String player){
        boolean colValid = false;
        int counter = 0;
        for (int c = 0; c < board.length; c++) {
            for (int r = 0; r < board[0].length; r++) {
                if (board[r][c].equals(player)) {
                    counter++;
                }
            }
            if (counter == 3) {
                colValid = true;
            }
            counter = 0;
        }
        return colValid;
    }
    private static boolean isDiagonalWin(String player){
boolean diagonalValid = false;

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            diagonalValid = true;
        } else if (board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player)) {
            diagonalValid = true;
        }
return diagonalValid;
    }
    private static boolean isWin(String player){
        boolean winValid = false;
        if (isColWin(player)) {
            winValid = true;
        }
        else if (isRowWin(player)) {
            winValid = true;
        }
        else if (isDiagonalWin(player)) {
            winValid = true;
        }
        return winValid;
    }
    private static boolean isTie(){
        boolean tie = false;
        int counter = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c].equals("-")) {
                    counter++;
                    break;
                }
            }
        }
        if (counter == 0) {
            tie = true;
        }
        return tie;
    }
}
