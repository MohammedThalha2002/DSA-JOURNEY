package DynamicProgramming;

import java.util.HashMap;

public class MinCoinChange {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = { 1, 2, 3 };
        int res = findMinNumberOfCoins(amount, coins);
        System.out.println(res < 0 ? "Change cannot be formed" : res);
    }

    private static int findMinNumberOfCoins(int amount, int[] coins) {
        return findMinNumberOfCoins(amount, coins, new HashMap<>());
    }

    private static int findMinNumberOfCoins(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subAmt = amount - coin;
            if (subAmt >= 0) {
                int len = findMinNumberOfCoins(subAmt, coins, memo) + 1;
                if (len < min) {
                    min = len;
                }
            }
        }
        
        memo.put(amount, min);
        System.out.println(memo);
        return min;

    }
}
