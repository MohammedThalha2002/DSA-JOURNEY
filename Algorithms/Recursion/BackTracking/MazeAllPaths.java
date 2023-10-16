package Algorithms.Recursion.BackTracking;

public class MazeAllPaths {
    public static void main(String[] args) {
        int[][] arr = new int[3][3]; // initially it will be zeros
        printDestinationWays("", arr, 0, 0);

    }

    public static void printDestinationWays(String dest, int[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr.length - 1) {
            System.out.println(dest);
            return;
        }

        // if it is already visited
        if (arr[row][col] == 1) {
            return;
        }

        // marking as visited
        arr[row][col] = 1;

        // towards right
        if (col < arr.length - 1) {
            printDestinationWays(dest + "R", arr, row, col + 1);
        }

        // towards left
        if (col > 0) {
            printDestinationWays(dest + "L", arr, row, col - 1);
        }

        // towards top
        if (row > 0) {
            printDestinationWays(dest + "T", arr, row - 1, col);
        }

        // towards bottom
        if (row < arr.length - 1) {
            printDestinationWays(dest + "B", arr, row + 1, col);
        }

        // backtracking
        // marking the path as unvisisted for the next findings
        arr[row][col] = 0;

    }
}
