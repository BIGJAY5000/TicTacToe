import java.util.Scanner;
public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String [][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        clearBoard();
        showBoard();
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
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c<board[0].length;c++) {
                if (board[r][c].equals("x") || board[r][c].equals("o")) {
                    valid = true;
                }
            }
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
    private static boolean isTie(String player){

    }
}
