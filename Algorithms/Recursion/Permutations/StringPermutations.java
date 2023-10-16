package Algorithms.Recursion.Permutations;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        // printPermutations("", str);
        System.out.println(printPermutationsList("", str));
        System.out.println(countPermutations("", str));
    }

    public static void printPermutations(String p, String up) {

        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i, p.length());
            String newPr = first + ch + last;
            printPermutations(newPr, up.substring(1));
        }
    }

    public static List<String> printPermutationsList(String pr, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(pr);
            return list;
        }

        char ch = up.charAt(0);

        List<String> list = new ArrayList<>();

        for (int i = 0; i <= pr.length(); i++) {
            String first = pr.substring(0, i);
            String last = pr.substring(i, pr.length());
            String newPr = first + ch + last;
            List<String> bottom = printPermutationsList(newPr, up.substring(1));
            list.addAll(bottom);
        }

        return list;
    }

    public static int countPermutations(String p, String up) {

        if (up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0);
        int count = 0;

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i, p.length());
            String newPr = first + ch + last;
            count += countPermutations(newPr, up.substring(1));
        }

        return count;
    }
}
