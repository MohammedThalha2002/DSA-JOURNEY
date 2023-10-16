package Algorithms.Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class ReachDestination {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        System.out.println("The total ways to reach the destination is : " + countDestinationWays(0, 0, arr));
        System.out.println(printDestinationWays("", 0, 0, arr));
        System.out.println("With Diagonal movement");
        System.out.println(printDestinationWaysDiagonal("", 0, 0, arr));
    }

    public static List<String> printDestinationWays(String dest, int row, int col, int[][] arr) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(dest);
            return list;
        }

        List<String> list = new ArrayList<>();

        // taking the downwards direction
        if (row < arr.length - 1) {
            list.addAll(printDestinationWays(dest + "D", row + 1, col, arr));
        }
        // taking the rightwards direction
        if (col < arr[0].length - 1) {
            list.addAll(printDestinationWays(dest + "R", row, col + 1, arr));
        }

        return list;
    }

    public static int countDestinationWays(int row, int col, int[][] arr) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            return 1;
        }

        int count = 0;

        if (row < arr.length - 1) {
            count += countDestinationWays(row + 1, col, arr);
        }

        if (col < arr[0].length - 1) {
            count += countDestinationWays(row, col + 1, arr);
        }

        return count;
    }

    public static List<String> printDestinationWaysDiagonal(String dest, int row, int col, int[][] arr) {
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(dest);
            return list;
        }

        List<String> list = new ArrayList<>();

        // taking the diagonal direction
        if (row < arr.length - 1 && col < arr[0].length - 1) {
            list.addAll(printDestinationWaysDiagonal(dest + "D", row + 1, col + 1, arr));
        }

        // taking the downwards direction
        if (row < arr.length - 1) {
            list.addAll(printDestinationWaysDiagonal(dest + "H", row + 1, col, arr));
        }
        // taking the rightwards direction
        if (col < arr[0].length - 1) {
            list.addAll(printDestinationWaysDiagonal(dest + "V", row, col + 1, arr));
        }

        return list;
    }
}
