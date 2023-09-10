package Algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 2 };
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // find the minimum and swap it with the i'th index
            int minIndex = getMinIndex(arr, i, arr.length);
            swap(arr, i, minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int getMinIndex(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (arr[i] < min) {
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
