package Algorithms.Recursion.BackTracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        int ans = nKnights(board, 0);
        System.out.println("\nThe total possibilities of arrangements are " + ans);
    }

    public static int nKnights(boolean[][] board, int row) {
        // base condition
        if (row == board.length) {
            // found the answer
            display(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            // checking the place is safe then placing the kngiht
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nKnights(board, row + 1);
                board[row][col] = false; // making back to false
            }
        }

        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        // large L's
        if (isValid(board, row + 2, col + 1)) {
            if (board[row + 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row + 2, col - 1)) {
            if (board[row + 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        // small L's
        if (isValid(board, row + 1, col + 2)) {
            if (board[row + 1][col + 2]) {
                return false;
            }
        }
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    public static void display(boolean[][] board) {
        System.out.println("------------------");
        for (boolean[] row : board) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("K ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
