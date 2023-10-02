package Algorithms.Recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {};
        selectionSort(arr, 0, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr, int r, int c, int max) {
        if (r == arr.length - 1 || arr.length < 2) {
            return;
        }
        
        // selecting maximum and putting at the end
        if (c < (arr.length - r)) {
            if (arr[c] >= arr[max]) {
                max = c;
            }
            selectionSort(arr, r, c + 1, max);
        } else {
            // swap the max with the end index
            int t = arr[arr.length - 1 - r];
            arr[arr.length - 1 - r] = arr[max];
            arr[max] = t;
            selectionSort(arr, r + 1, 0, 0);
        }
    }
}
