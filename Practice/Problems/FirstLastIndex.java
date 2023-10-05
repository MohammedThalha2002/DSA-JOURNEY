package Practice.Problems;

import java.util.Arrays;

public class FirstLastIndex {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 3, 3, 4, 5, 6 };
        int target = 3;
        int[] indexes = findIndexes(arr, target);
        System.out.println(Arrays.toString(indexes));
    }

    private static int[] findIndexes(int[] arr, int target) {
        int first = searchFirst(arr, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = searchLast(arr, target);
        return new int[] { first, last };
    }

    private static int searchFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static int searchLast(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

}
