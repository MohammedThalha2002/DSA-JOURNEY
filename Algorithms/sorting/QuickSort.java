package Algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 2, 0, 2, 6, 7 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];

        while (s <= e) {

            while (arr[s] < pivot) {
                s++;
            }

            while (arr[e] > pivot) {
                e--;
            }

            // while running the two while loops - both s and e will be in the
            // vioalted position
            // SO we swap
            if (s <= e) {
                // swap
                int t = arr[s];
                arr[s] = arr[e];
                arr[e] = t;
                s++;
                e--;
            }
        }

        // on completion the first pivot will be in its original position
        // now we have to sorted the arr in the left and right half of the pivot
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
