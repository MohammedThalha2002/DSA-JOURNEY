package Algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3, 3, 3, 5 };
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // find the minimum and swap it with the i'th index
            int min = Integer.MAX_VALUE;
            int k = i; // to indicate the jth index for swaping
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    k = j;
                }
            }
            // swap
            arr[k] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }

}
