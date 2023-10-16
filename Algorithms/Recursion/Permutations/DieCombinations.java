package Algorithms.Recursion.Permutations;

import java.util.ArrayList;
import java.util.List;

public class DieCombinations {
    public static void main(String[] args) {
        int n = 4;
        printDieCombinations("", n);
        System.out.println(printDieCombinationsList("", n));
    }

    public static void printDieCombinations(String p, int n) {
        if (n == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= n; i++) {
            printDieCombinations(p + i, n-i);
        }
    }

    public static List<String> printDieCombinationsList(String p, int n) {
        if (n == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<String> bottom = printDieCombinationsList(p + i, n-i);
            list.addAll(bottom);
        }

        return list;
    }
}
