package Patterns.SlidingWindow;

import java.util.HashMap;

public class LongestSubStrWithKDisChar {
    public static void main(String[] args) {
        String str = "aabacbebe";
        int k = 3;
        System.out.println(slidingWindowApproach(str, k));
    }

    private static int slidingWindowApproach(String str, int k) {
        int max = -1;
        int winStart = 0, winEnd = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            winEnd++;
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            // System.out.println(map);

            if (map.size() == k) {
                max = Math.max(max, winEnd - winStart);
                // System.out.println(max);
            }

            while (map.size() > k) {
                char curr = str.charAt(winStart);
                winStart++;
                map.put(curr, map.get(curr) - 1);
                //
                if (map.get(curr) == 0) {
                    map.remove(curr);
                }
            }
        }
        return max;
    }
}
