package Algorithms.Recursion.Permutations;

import java.util.*;

public class PhoneCombinations {

    public static void main(String[] args) {
        String num = "12";
        HashMap<Integer, String> phone = new HashMap<>();
        phone.put(1, "ABC");
        phone.put(2, "DEF");
        phone.put(3, "GHI");
        phone.put(4, "JKL");
        phone.put(5, "MNO");
        phone.put(6, "PQR");
        phone.put(7, "STU");
        phone.put(8, "VWX");
        phone.put(9, "YZ");

        // findCombinations("", num, phone);
        System.out.println(findCombinationsList("", num, phone));
    }

    public static void findCombinations(String p, String up, HashMap<Integer, String> phone) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int n = Integer.parseInt(String.valueOf(up.charAt(0)));

        String chars = phone.get(n);

        for (int i = 0; i < chars.length(); i++) {
            findCombinations(p + chars.charAt(i), up.substring(1), phone);
        }

    }

    public static List<String> findCombinationsList(String p, String up, HashMap<Integer, String> phone) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int n = Integer.parseInt(String.valueOf(up.charAt(0)));

        String chars = phone.get(n);

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < chars.length(); i++) {
            List<String> bottom = findCombinationsList(p + chars.charAt(i), up.substring(1), phone);
            list.addAll(bottom);
        }

        return list;
    }
}