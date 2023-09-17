package Maths;

public class FindSingle {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 2, 4, 4 };
        // all the elements in the array is repeated twice except one. Find that!
        int res = findSingle(arr);
        System.out.println(res);
    }

    private static int findSingle(int[] arr) {
        int res = 0;
        for (int val : arr) {
            res ^= val;
        }
        return res;
    }
}
