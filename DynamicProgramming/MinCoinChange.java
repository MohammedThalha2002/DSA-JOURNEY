package DynamicProgramming;

import java.util.HashMap;

public class MinCoinChange {
    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        int res = findMinNumberOfCoins(amount, coins);
        System.out.println(res < 0 ? "Change cannot be formed" : res);
        System.out.println("Without Duplicates");
        System.out.println(findMinNumberOfCoinsWithoutDup(amount, 0, coins));

    }

    private static int findMinNumberOfCoins(int amount, int[] coins) {
        // in this method duplicates occurs and thus it is not a valid way
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

    public static int findMinNumberOfCoinsWithoutDup(int amount, int idx, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (idx >= coins.length) {
            return 0;
        }

        int totalPoss = 0;
        int coin = coins[idx];
        for (int i = 0; i * coin <= amount; i++) {
            int res = findMinNumberOfCoinsWithoutDup(amount - (i * coin), idx + 1, coins);
            totalPoss += res;
        }

        return totalPoss;
    }
}
