package DynamicProgramming;

import java.util.HashMap;

public class NonAdjacentSum {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 12, 7 };
        int maxAdjSum = findMaxAdjSum(arr, 0, new HashMap<>());
        System.out.println(maxAdjSum);
    }

    private static int findMaxAdjSum(int[] nums, int i, HashMap<Integer, Integer> memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int take = findMaxAdjSum(nums, i + 2, memo) + nums[i];
        int dontTake = findMaxAdjSum(nums, i + 1, memo);

        int res = Math.max(take, dontTake);
        memo.put(i, res);
        return res;
    }
}
