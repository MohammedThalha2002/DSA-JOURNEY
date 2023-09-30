package Algorithms.Recursion.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int target = 10;
        int res = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println(res);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid - 1);
        }
    }

}
