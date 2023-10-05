package Algorithms.Recursion.SubSets;

import java.util.ArrayList;

public class ArraySubSets {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        printSubsets(arr);
    }

    public static void printSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int val : arr) {
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(val);
                outer.add(inner);
            }
        }

        for (ArrayList<Integer> arrayList : outer) {
            System.out.println(arrayList);
        }

    }

    public static void printSubsetsWithoutDuplicates(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size();
        }
    }
}
