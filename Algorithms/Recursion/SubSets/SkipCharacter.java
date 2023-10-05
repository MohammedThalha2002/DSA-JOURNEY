package Algorithms.Recursion.SubSets;

import java.util.ArrayList;

public class SkipCharacter {
    public static void main(String[] args) {
        String str = "bacdafaabghaaaa";
        char skip = 'a';
        str = skipAlphabet(str, skip);
        System.out.println(str);
    }

    private static String skipAlphabet(String str, char skip) {
        if (str.length() < 1) {
            return str;
        }

        char target = str.charAt(0);

        if (target == skip) {
            return skipAlphabet(str.substring(1), skip);
        }

        return target + skipAlphabet(str.substring(1), skip);
    }
}
