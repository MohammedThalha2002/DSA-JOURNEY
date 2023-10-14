package Algorithms.searching;

public class CeilOfNumber {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
        int ceil = 4;
        int res = ceilofNumber(arr, ceil);
        System.out.println("The ceil of the number from the arry is " + res);
    }

    public static int ceilofNumber(int[] arr, int ceil) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (ceil > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (start + 1 >= arr.length) {
            return -1;
        } else
            return arr[start + 1];

    }
}
