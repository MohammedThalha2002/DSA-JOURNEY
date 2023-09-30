package Algorithms.Recursion;

public class NumReverse {
    static int rev = 0;

    public static void main(String[] args) {
        reverseRec1(123);
        System.out.println(reverseRec2(1234));
    }

    // without recursion
    public static int reverse(int n) {
        int rem, rev = 0;
        while (n > 0) {
            rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }

    public static void reverseRec1(int n) {

        // base condition
        if (n == 0) {
            System.out.println(rev);
            return;
        }

        int rem = n % 10;
        rev = rev * 10 + rem;
        reverseRec1(n / 10);
    }

    public static int reverseRec2(int n) {

        if (n == 0) {
            return 0;
        }

        int rem = n % 10;
        // rem * 10^3 or 10^2 .... + n/10
        return rem * (int) Math.pow(10, ((int) Math.log10(n))) + reverseRec2(n / 10);
    }
}
