package Algorithms.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(134210));
        System.out.println(product(505));
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return n;
        }

        return (n % 10) + sum(n / 10);
    }

    public static int product(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return n;
        }

        return (n % 10) * product(n / 10);
    }
}
