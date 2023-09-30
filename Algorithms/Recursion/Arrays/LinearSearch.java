package Algorithms.Recursion.Arrays;

import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 4, 5, 6 };
        int target = 4;
        // System.out.println(linearSearch(arr, target, 0));
        // System.out.println(findAllIndex(arr, target, 0, new ArrayList<>()));
        System.out.println(findIndexs(arr, target, 0));
    }

    public static int linearSearch(int[] arr, int target, int i) {

        if (arr[i] == target) {
            return i;
        }

        if (i == arr.length - 1) {
            return -1;
        }

        return linearSearch(arr, target, ++i);
    }

    public static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndex(arr, target, index + 1, list);
    }

    // so so important
    // using list only inside the recursion body
    public static ArrayList<Integer> findIndexs(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();

        if (i == arr.length) {
            return list;
        }

        if (arr[i] == target) {
            list.add(i);
        }

        ArrayList<Integer> ansFromBelow = findIndexs(arr, target, i + 1);
        list.addAll(ansFromBelow);

        return list;
    }
}
