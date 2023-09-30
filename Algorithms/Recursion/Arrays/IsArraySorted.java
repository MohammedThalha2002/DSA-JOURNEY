package Algorithms.Recursion.Arrays;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = { -10, 1, 2, 3, 4, 5, 6,-1, 7, 10 };
        System.out.println(isArraySorted(arr));
    }

    public static boolean isArraySorted(int[] arr) {
        return helper(arr, 0);
    }

    private static boolean helper(int[] arr, int i) {
        if (i == arr.length - 1) {
            // it reached the end of the array, hence the array should be sorted
            return true;
        }
        // check for the next element and again check for the rest of the elements
        return (arr[i] < arr[i + 1]) && helper(arr, ++i);

    }
}
