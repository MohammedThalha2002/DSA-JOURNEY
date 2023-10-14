package Algorithms.searching;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
        int floor = 16;
        int res = floorofNumber(arr, floor);
        System.out.println("The floor of the number from the arry is " + res);
    }

    public static int floorofNumber(int[] arr, int floor) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (floor > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;

        }

        if (end < 0)
            return -1;
        else
            return arr[end];
    }
}
