package Algorithms.searching;

import java.util.Arrays;

public class FindStartingAndEnding {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 4, 4, 5, 6, 7 };
        int target = 4;
        int[] res = findStartingAndEnding(arr, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findStartingAndEnding(int[] arr, int target) {
        int findFirstIndex = findStartingIndex(arr, target, true);
        int findLastIndex = findStartingIndex(arr, target, false);
        return new int[] { findFirstIndex, findLastIndex };
    }

    public static int findStartingIndex(int[] arr, int target, boolean state) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                if (state) {
                    end = mid - 1; // this is for searching of the first index of the target element
                } else {
                    start = mid + 1; // this is for searching of the last index of the target element
                }
            } else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return ans;
    }
}