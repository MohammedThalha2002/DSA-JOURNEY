package Algorithms.Recursion.BackTracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int ans = nQueens(board, 0);
        System.out.println("\nThe total possibilities of arrangements are " + ans);
    }

    public static int nQueens(boolean[][] board, int row) {
        // base condition
        if (row == board.length) {
            // found the answer
            display(board);
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            // checking the place is safe then placing the Queen
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueens(board, row + 1);
                board[row][col] = false; // making back to false
            }
        }

        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        // checking top
        for (int r = row; r >= 0; r--) {
            if (board[r][col] == true) {
                return false;
            }
        }
        // checking Left Diagonal
        int left = col;
        for (int r = row; r >= 0; r--) {
            if (board[r][left] == true) {
                return false;
            }
            if (r == 0 || left == 0) {
                break;
            }
            left--;
        }

        // checking Right Diagonal
        int right = col;
        for (int r = row; r >= 0; r--) {
            if (board[r][right] == true) {
                return false;
            }
            if (r == 0 || right == board.length - 1) {
                break;
            }
            right++;
        }

        return true;
    }

    public static void display(boolean[][] board) {
        System.out.println();
        for (boolean[] row : board) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
