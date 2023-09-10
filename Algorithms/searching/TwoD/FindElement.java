package Algorithms.searching.TwoD;

import java.util.Arrays;

// It is a sorted array in both rows and columns

public class FindElement {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int target = 1;
        int[] res = findIndex(arr, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findIndex(int[][] arr, int target) {
        int col = arr[0].length - 1;
        int row = 0;
        while (row < arr.length && col >= 0) {
            int val = arr[row][col];
            if (val == target)
                return new int[] { row, col };
            else if (val > target) {
                col--;
            } else if (val < target) {
                row++;
            }
        }
        return new int[] { -1, -1 };
    }
}