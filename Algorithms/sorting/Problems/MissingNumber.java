package Algorithms.sorting.Problems;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 0, 5, 3 };
        // 3 is missing
        int res = missingNumber(arr);
        System.out.println(res);
    }

    public static int missingNumber(int[] arr) {
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i)
                return i;
        }
        return arr.length;
    }

    public static void cyclicSort(int[] arr) {
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == len) {
                i++;
            } else if (arr[i] != i) {
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
