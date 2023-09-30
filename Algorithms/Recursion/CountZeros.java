package Algorithms.Recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(200022));
    }

    public static int countZeros(int n) {
        return helper(n, 0);
    }

    // special case : passing a number for the further calls
    public static int helper(int n, int count) {
        if (n == 0) {
            return count;
        }

        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, count + 1);
        } else {
            return helper(n / 10, count);
        }
    }
}
