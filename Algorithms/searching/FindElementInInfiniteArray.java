package Algorithms.searching;

public class FindElementInInfiniteArray {
    public static void main(String[] args) {
        // sorted array
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20 };
        int target = 10;
        int res = findRange(arr, target);
        System.out.println(res);
    }

    public static int findRange(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newstart = end + 1;
            end = end + (end + start - 1) * 2;
            start = newstart;
        }
        return binarySearch(arr, start, end, target);
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return arr[mid];
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
