package Algorithms.Recursion.SubSets;

import java.util.ArrayList;

public class StringSubSets {

    public static void main(String[] args) {
        String str = "AB";
        // printSubSets("", str);
        System.out.println(subsetsOfStr("", str));
    }

    public static void printSubSets(String first, String sec) {
        // base
        if (sec.length() == 0) {
            System.out.println(first);
            return;
        }

        // take it
        printSubSets(first + sec.charAt(0), sec.substring(1));
        // remove it
        printSubSets(first, sec.substring(1));
    }

    public static ArrayList<String> subsetsOfStr(String first, String sec) {
        // base
        if (sec.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(first);
            return list;
        }

        // take it
        ArrayList<String> left = subsetsOfStr(first + sec.charAt(0), sec.substring(1));
        // remove it
        ArrayList<String> right = subsetsOfStr(first, sec.substring(1));
        left.addAll(right);
        return left;
    }

}
