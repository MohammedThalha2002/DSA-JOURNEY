package Algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3, 3, 3, 5 };
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        // on each iterations, the elements from 0 to i+1 will be sorted
        // So, the i just need to run till len-1
        for (int i = 0; i < arr.length - 1; i++) {
            // the inner loop will run in the reverse direction
            // j will run from i+1 to 1(as it is using j-1)
            for (int j = i + 1; j > 0; j--) {
                // if the j-1 is greater than j => swap
                // else break the loop, coz the rest is already sorted
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
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
