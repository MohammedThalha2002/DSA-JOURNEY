package Algorithms.Recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 7, 1, 2, 0, 4, 7 };
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr, int r, int c, int maxIndex) {
        if (r == 0 || arr.length < 2) {
            return;
        }

        if (c < r) {
            // find the max Index
            if (arr[c] > arr[maxIndex]) {
                maxIndex = c;
            }
            selectionSort(arr, r, c + 1, maxIndex);
        } else {
            // swap the max with the r-1
            int t = arr[r - 1];
            arr[r - 1] = arr[maxIndex];
            arr[maxIndex] = t;
            // check for the next iteration by reducing the row
            selectionSort(arr, r - 1, 0, 0);
        }
    }
}
