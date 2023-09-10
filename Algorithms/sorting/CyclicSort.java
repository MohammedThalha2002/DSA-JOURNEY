package Algorithms.sorting;

import java.util.*;

// CYCLIC SORT is only applicable is the elements in the array are from 1 to N (len of the array)
// Time Complexity is O(N)

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };
        cyclicSort(arr);
    }

    public static void cyclicSort(int[] arr) {
        int len = arr.length - 1;
        int i = 0;
        while (i <= len) {
            if (arr[i] != i + 1) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
