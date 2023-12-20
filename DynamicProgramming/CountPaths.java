package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

public class CountPaths {
    public static void main(String[] args) {
        int[][] paths = { { 0, 0, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };
        int totalWays = countTotalWays(paths);
        System.out.println(totalWays);
    }

    private static int countTotalWays(int[][] paths) {
        return countTotalWays(0, 0, paths, new HashMap<>());
    }

    private static int countTotalWays(int r, int c, int[][] paths, HashMap<List<Integer>, Integer> memo) {
        if (r == paths.length - 1 && c == paths[0].length - 1) {
            return 1;
        }

        if (paths[r][c] == 1) {
            return 0;
        }

        List<Integer> keys = List.of(r,c);

        if (memo.containsKey(keys)) {
            return memo.get(keys);
        }

        int right = 0, down = 0;

        if (c < paths[0].length - 1) {
            right = countTotalWays(r, c + 1, paths, memo);
        }

        if (r < paths.length - 1) {
            down = countTotalWays(r + 1, c, paths, memo);
        }

        int res = right + down;
        memo.put(keys, res);
        System.out.println(memo);

        return res;
    }
}
