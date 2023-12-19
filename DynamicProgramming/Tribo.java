package DynamicProgramming;

import java.util.HashMap;

public class Tribo {
    public static void main(String[] args) {
        int n = 10;
        double res = tribinacci(n, new HashMap<>());
        System.out.println(res);
    }

    public static double tribinacci(int n, HashMap<Integer, Double> memo) {
        if (n <= 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        double res = tribinacci(n - 1, memo) + tribinacci(n - 2, memo) + tribinacci(n - 3, memo);
        memo.put(n, res);
        return res;
    }
}
