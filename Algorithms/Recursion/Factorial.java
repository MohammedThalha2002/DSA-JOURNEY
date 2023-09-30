package Algorithms.Recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(1));
    }

    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
}
