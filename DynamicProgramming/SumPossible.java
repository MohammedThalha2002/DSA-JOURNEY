package DynamicProgramming;

import java.util.HashMap;

public class SumPossible {
    public static void main(String[] args) {
        int[] arr = { 6, 4, 10 };
        int sum = 15;

        System.out.println(isSumPossible(sum, arr, new HashMap<>()));
    }

    private static boolean isSumPossible(int sum, int[] arr, HashMap<Integer, Boolean> memo) {
        if (sum == 0) {
            return true;
        }

        if (memo.containsKey(sum)) {
            return memo.get(sum);
        }

        boolean state = false;

        for (int i = 0; i < arr.length; i++) {
            if (sum - arr[i] >= 0) {
                boolean res = isSumPossible(sum - arr[i], arr, memo);
                memo.put(sum - arr[i], res);
                state = state || res;
            }
        }
        System.out.println(memo);
        return state;
    }
}
