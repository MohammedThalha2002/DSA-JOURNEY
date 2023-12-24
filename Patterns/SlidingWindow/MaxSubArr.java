package Patterns.SlidingWindow;

public class MaxSubArr {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int size = 3;
        System.out.println(bruteForceApproach(arr, size));
        System.out.println(slidingWindowApproach(arr, size));
    }

    // Time Complexity => O(n*k)
    private static int bruteForceApproach(int[] arr, int k) {
        int size = arr.length - k + 1;
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    // Time Complexity => O(n)
    private static int slidingWindowApproach(int[] arr, int k) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >= k - 1) {
                max = Math.max(max, sum);
                sum -= arr[i - k + 1];
            }
        }

        return max;
    }
}
