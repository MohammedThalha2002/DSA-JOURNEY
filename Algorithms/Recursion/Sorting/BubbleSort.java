package Algorithms.Recursion.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 7, 1, 2, 0, 4, 7 };
        bubbleSort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int r, int c) {
        if (r == 0 || arr.length < 2) {
            return;
        }

        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                // swap
                int t = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = t;
            }
            bubbleSort(arr, r, c + 1);
        } else {
            bubbleSort(arr, r - 1, 0);
        }
    }
}
