package Algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        sc.close();
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
