package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

public class MaxPathSum {
    public static void main(String[] args) {
        int[][] path = { { 1, 2, 3 }, { 4, 5, 6 } };
        int maxPath = findMaxPath(path);
        System.out.println(maxPath);
    }

    private static int findMaxPath(int[][] path) {
        return findMaxPath(0, 0, path, 0, new HashMap<>());
    }

    private static int findMaxPath(int r, int c, int[][] path, int sum, HashMap<List<Integer>, Integer> memo) {
        if (r == path.length - 1 && c == path[0].length - 1) {
            return path[r][c];
        }

        List<Integer> keys = List.of(r, c);
        if (memo.containsKey(keys)) {
            return memo.get(keys);
        }

        int right = 0;
        int down = 0;

        if (c < path[0].length - 1) {
            right = findMaxPath(r, c + 1, path, sum, memo);
        }

        if (r < path.length - 1) {
            down = findMaxPath(r + 1, c, path, sum, memo);
        }

        int res = Math.max(right, down) + path[r][c];
        memo.put(keys, res);
        System.out.println(memo);

        return res;
    }
}
