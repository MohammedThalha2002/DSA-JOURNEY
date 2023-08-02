package Algorithms.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 1;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int res = binarySearch(arr, target);
        System.out.println("The index of the element is " + res);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2; // the (start + end) acn sometime exceeds the int range
            // so go with start + (end - start)/2 => for good opti
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
        } 
        return -1;
    }
}
