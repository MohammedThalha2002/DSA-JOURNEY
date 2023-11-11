package DynamicProgramming;

import java.util.HashMap;

public class Fibo {
    public static void main(String[] args) {
        HashMap<Double, Double> memo = new HashMap<>();
        long startTime, endTime;
        // System.out.println("Without Memoization");
        // startTime = System.nanoTime();
        // System.out.println(fibo(40));
        // endTime = System.nanoTime();
        // System.out.println("Time Taken : " + (endTime - startTime) / 100000 + "ms");
        //
        System.out.println("With Memoization");
        startTime = System.nanoTime();
        System.out.println(fibo(40, memo));
        endTime = System.nanoTime();
        System.out.println("Time Taken : " + (endTime - startTime) / 100000 + "ms");
    }

    public static double fibo(double n, HashMap<Double, Double> memo) {
        if (n < 2) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        double res = fibo(n - 1, memo) + fibo(n - 2, memo);
        if (!memo.containsKey(n)) {
            memo.put(n, res);
        }
        return res;

    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);

    }
}
