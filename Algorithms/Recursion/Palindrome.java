package Algorithms.Recursion;

public class Palindrome {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(n == numRev(n));
    }

    public static int numRev(int n) {

        if (n == 0) {
            return 0;
        }

        int rem = n % 10;
        // rem * 10^3 or 10^2 .... + n/10
        return rem * (int) Math.pow(10, ((int) Math.log10(n))) + numRev(n / 10);
    }
}
