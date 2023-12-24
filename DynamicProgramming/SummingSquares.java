package DynamicProgramming;

import java.util.HashMap;

public class SummingSquares {
    public static void main(String[] args) {
        int n = 10;
        int minNumRequiredForSummingSquares = findMinSummingSquares(n, new HashMap<>());
        System.out.println(minNumRequiredForSummingSquares);
    }

    private static int findMinSummingSquares(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            int squares = i * i;
            int numSquares = findMinSummingSquares(n - squares, memo) + 1;
            if (numSquares < min) {
                min = numSquares;
            }
        }
        memo.put(n, min);
        System.out.println(memo);

        return min;
    }
}
