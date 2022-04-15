package TicTacToe;

// Tic-Tac-Toe Game.
import java.util.*;

public class TicTacToe {

    static String[] board;
    static String turn;

    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            // check if token X won
            if (line.equals("XXX")) return "X";

            // check if token O won
            else if (line.equals("OOO")) return "O";
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) break;
            else if (a == 8) {
                return "draw";
            }
        }
        System.out.println( turn + "'s turn \r\n");
        return null;
    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|___|___|___|");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        board = new String[9];
        int totalTurns = board.length;
        turn = "X";
        String winner = null;

        for (int turn = 0; turn < totalTurns; turn++) board[turn] = String.valueOf(turn + 1);

        System.out.println("Welcome to Tic Tac Toe.");
        printBoard();

        System.out.println("Player 1 is X and will play first.");
        System.out.println("Enter a cell number for selection");

        while (winner == null) {
            int selectedCell;
            try {
                selectedCell = input.nextInt();
                if (!(selectedCell > 0 && selectedCell <= 9)) {
                    System.out.println("Invalid input! Retry");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; Retry with valid input");
                continue;
            }

            if (board[selectedCell - 1].equals(String.valueOf(selectedCell))) {
                board[selectedCell - 1] = turn;
                turn = (turn.equals("X")) ? "0" : "X";
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Invalid Move! Retry.");
            }
        }

        if (winner.equalsIgnoreCase("draw")) System.out.println("It's a draw!");
        else System.out.println("Congratulations! " + winner + "'s have won!");

        input.close();
    }
}