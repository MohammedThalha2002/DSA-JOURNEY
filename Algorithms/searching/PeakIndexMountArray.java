package Algorithms.searching;

public class PeakIndexMountArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 8, 4, 3, 1 };
        int res = findPeak(arr);
        System.out.println(res);
    }

    public static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // At the end both the start and the end pointer will point the peak value
        while (start != end) {
            int mid = start + (end - start) / 2;

            // Increasing order
            if (arr[mid] < arr[mid + 1])
                start = mid + 1;
            else if (arr[mid] > arr[mid + 1])
                end = mid;

        }
        return arr[start];
    }
}
