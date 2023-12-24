package Patterns.SlidingWindow;

import java.util.Arrays;

public class FIndAvgSubArr {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int size = 5;
        System.out.println(Arrays.toString(bruteForceApproach(arr, size)));
        System.out.println(Arrays.toString(slidingWindowApproach(arr, size)));
    }

    // Time Complexity = O(n^2)
    private static double[] bruteForceApproach(int[] arr, int k) {
        int size = arr.length - k + 1;
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            res[i] = sum / k;
        }
        return res;
    }

    // Time Complexity = O(n)
    private static double[] slidingWindowApproach(int[] arr, int k) {
        int size = arr.length - k + 1;
        double[] res = new double[size];

        int index = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                res[index++] = sum / k;
                sum -= arr[i - k + 1];
            }
        }

        return res;
    }
}
