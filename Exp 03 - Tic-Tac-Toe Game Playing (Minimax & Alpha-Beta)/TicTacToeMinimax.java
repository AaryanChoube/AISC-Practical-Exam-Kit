import java.util.Scanner;

public class TicTacToeMinimax {
    static final char HUMAN = 'X';
    static final char AI = 'O';
    static final char EMPTY = ' ';

    public static void printBoard(char[][] board) {
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---|---|---");
        }
        System.out.println("");
    }

    public static boolean isMovesLeft(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == EMPTY) return true;
        return false;
    }

    public static int evaluate(char[][] b) {
        for (int row = 0; row < 3; row++) {
            if (b[row][0] == b[row][1] && b[row][1] == b[row][2]) {
                if (b[row][0] == AI) return +10;
                else if (b[row][0] == HUMAN) return -10;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
                if (b[0][col] == AI) return +10;
                else if (b[0][col] == HUMAN) return -10;
            }
        }
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == AI) return +10;
            else if (b[0][0] == HUMAN) return -10;
        }
        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == AI) return +10;
            else if (b[0][2] == HUMAN) return -10;
        }
        return 0;
    }

    public static int minimax(char[][] board, int depth, boolean isMax) {
        int score = evaluate(board);
        if (score == 10) return score - depth;
        if (score == -10) return score + depth;
        if (!isMovesLeft(board)) return 0;

        if (isMax) {
            int best = -1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = AI;
                        best = Math.max(best, minimax(board, depth + 1, false));
                        board[i][j] = EMPTY;
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = HUMAN;
                        best = Math.min(best, minimax(board, depth + 1, true));
                        board[i][j] = EMPTY;
                    }
                }
            }
            return best;
        }
    }

    public static int[] findBestMove(char[][] board) {
        int bestVal = -1000;
        int[] bestMove = {-1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = AI;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = EMPTY;
                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("  Tic-Tac-Toe Minimax Agent (AISC Exp 3)");
        System.out.println("========================================");
        System.out.println("You are 'X' and AI is 'O'. Position numbers 1 to 9:");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---|---|---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---|---|---");
        System.out.println(" 7 | 8 | 9 ");

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        System.out.println("\nAI calculating optimal response if Human plays center (pos 5):");
        board[1][1] = HUMAN;
        printBoard(board);

        int[] aiMove = findBestMove(board);
        System.out.println("Minimax AI selects row " + aiMove[0] + ", col " + aiMove[1] + " (Optimal Corner response)");
        board[aiMove[0]][aiMove[1]] = AI;
        printBoard(board);

        System.out.println("Strategy: Minimax Decision Tree (Adversarial Search)");
        System.out.println("Result: AI is theoretically unbeatable (always wins or draws).");
        System.out.println("========================================");
    }
}
