package Algorithms.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(5));
    }

    public static int fibo(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
