package ZScalar;

import java.util.*;

public class CanMakePalindromeFromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] prefixCount = new int[n + 1][26];
        // prefixCount[i][j] matrix, calculate number of letter from range [0,i] for j
        // letter.
        for (int i = 0; i < n; i++) {
            prefixCount[i + 1] = prefixCount[i].clone();
            prefixCount[i + 1][s.charAt(i) - 'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];
            int k = q[2];
            int count = 0;
            // count odd letters number from range [start, end]
            for (int i = 0; i < 26; i++) {
                count += (prefixCount[end + 1][i] - prefixCount[start][i]) % 2;
            }
            res.add(count / 2 <= k);
        }
        return res;
    }
}