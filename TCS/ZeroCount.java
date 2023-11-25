package TCS;

import java.util.Scanner;

public class ZeroCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input reading
        int L = scanner.nextInt();
        int K = scanner.nextInt();

        // Function call
        int result = findLongestConsecutiveZeros(L, K);

        // Output
        System.out.print(result);
    }

    public static int findLongestConsecutiveZeros(int L, int K) {
        if (K == 0) {
            return L;
        } else if (K == 1) {
            return 1;
        } else {
            // The minimum length of the longest consecutive zeros
            int minConsecutiveZeros = 0;

            // Calculate the minimum length of the longest consecutive zeros
            if (K <= L / 2) {
                minConsecutiveZeros = 1;
            } else {
                minConsecutiveZeros = L - K;
            }

            return minConsecutiveZeros;
        }
    }
}