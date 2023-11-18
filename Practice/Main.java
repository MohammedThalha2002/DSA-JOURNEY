package Practice;

import java.util.*;

public class Main {
    static final long INF = (long) 1e9 + 7;
    static final long MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();
            List<Integer> ans = new ArrayList<>();
            boolean ok = true;

            for (char x : s.toCharArray()) {
                if (x != c) {
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                for (int i = 1; i <= n; i++) {
                    ok = true;
                    for (int j = i; j <= n; j += i - 1) {
                        ok &= (s.charAt(j - 1) == c);
                    }
                    if (ok) {
                        ans.add(i);
                        break;
                    }
                }
            }

            List<Integer> user = solve(n, c, s);

            if (user.size() != ans.size()) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < user.size(); i++) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) != c && j % user.get(i) != 0) {
                        char[] sArray = s.toCharArray();
                        sArray[j] = c;
                        s = new String(sArray);
                    }
                }
            }

            long cnt = s.chars().filter(ch -> ch == c).count();

            if (cnt == n) {
                System.out.println(1);
            } else {
                System.out.println(-1);
                return;
            }
        }
    }

    static List<Integer> solve(int n, char c, String s) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean ok = true;
            for (int j = i; j <= n; j += i) {
                ok &= (s.charAt(j - 1) == c);
            }
            if (ok) {
                ans.add(i);
            }
        }

        return ans;
    }
}
