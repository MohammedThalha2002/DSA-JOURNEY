package Algorithms.Recursion.SubSets;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySubSets {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        // printSubsets(arr);
        printSubsetsWithoutDuplicates(arr);
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
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            int size = outer.size();
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = size - 1;
            }
            for (int j = start; j < size; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        for (ArrayList<Integer> arrayList : outer) {
            System.out.println(arrayList);
        }
    }
}
