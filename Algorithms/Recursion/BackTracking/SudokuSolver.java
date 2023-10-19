package Algorithms.Recursion.BackTracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        boolean isSolved = solveSukdoku(board);
        if(isSolved){
            display(board);
        } else {
            System.out.println("This sudoku cannot be solved");
        }
    }

    public static boolean solveSukdoku(int[][] board) {
        //
        boolean isSolved = true;
        int row = -1, col = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isSolved = false;
                    break;
                }
            }
            if (isSolved == false) {
                break;
            }
        }
        // if all the values are non - zero
        if (isSolved) {
            // sudoku is solved
            return true;
        }

        for (int val = 1; val <= 9; val++) {
            if (isSafe(board, row, col, val)) {
                board[row][col] = val;
                // if solved after the changes
                if (solveSukdoku(board)) {
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int target) {
        // checking row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == target) {
                return false;
            }
        }
        // checking column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == target) {
                return false;
            }
        }
        // checking the 3x3 matrix
        for (int i = 0; i < max; i++) {
            
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
