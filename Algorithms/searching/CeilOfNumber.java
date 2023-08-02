package Algorithms.searching;

public class CeilOfNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
        int ceil = 25;
        int res = ceilofNumber(arr, ceil);
        System.out.println("The ceil of the number from the arry is " + res);
    }

    public static int ceilofNumber(int[] arr, int ceil) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == ceil)
            return arr[mid];
            else if (ceil > arr[mid])
            start = mid + 1;
            else if (ceil < arr[mid])
            end = mid - 1;
        }

        if (start >= arr.length) {
            return -1;
        } else
            return arr[start];

    }
}
