package Algorithms.Recursion.Maze;

public class MazeWithObstacle {
    public static void main(String[] args) {
        // 1 => clear path
        // 0 => Obastacle path
        int[][] arr = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        printPath("", arr, 0, 0);
    }

    private static void printPath(String dest, int[][] arr, int row, int col) {
        if (row == arr.length - 1 && col == arr.length - 1) {
            System.out.println(dest);
            return;
        }

        // stopping further movement if the path have obstacle (0)
        if (arr[row][col] == 0) {
            return;
        }

        // moving towards the right
        if (row < arr.length - 1) {
            printPath(dest + "D", arr, row + 1, col);
        }

        // moving towards the down
        if (col < arr.length - 1) {
            printPath(dest + "R", arr, row, col + 1);
        }
    }
}
