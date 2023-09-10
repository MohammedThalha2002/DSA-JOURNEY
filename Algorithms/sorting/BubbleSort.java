package Algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3, 3, 3, 5 };
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swap;

        for (int i = 0; i < len; i++) {
            swap = false;
            for (int j = 1; j < len - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swap = true;
                }
            }
            // if swap doesnt occur for a particular value of i, it means the array is
            // sorted. So,,,,
            if (!swap) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
