package Algorithms.searching;

public class MaximumWealth {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 3, 2, 1 }, { 5, 6, 1 } };
        int res = findMaxWealth(arr);
        System.out.println(res);
    }

    public static int findMaxWealth(int[][] arr) {
        int maxWealth = Integer.MIN_VALUE;

        for (int[] row : arr) {
            int total = 0;
            for (int val : row) {
                total += val;
            }
            if (total > maxWealth)
                maxWealth = total;
        }

        return maxWealth;

    }
}
