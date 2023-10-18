package Algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 1, 100, -100 };
        arr = mergeSort(arr);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        System.out.println(Arrays.toString(left));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        System.out.println(Arrays.toString(right));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] sortedArr = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sortedArr[k] = left[i];
                i++;
            } else {
                sortedArr[k] = right[j];
                j++;
            }
            k++;

            while (i < left.length) {
                sortedArr[k] = left[i];
                i++;
                k++;
            }

            while (j < right.length) {
                sortedArr[k] = right[j];
                j++;
                k++;
            }
        }

        return sortedArr;
    }
}
