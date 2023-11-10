import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] arr = { 1, 0 };
        System.out.println(countSubsequences(arr, 10));
    }

    public static long countSubsequences(int[] arr, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> allSeq = generateSubsequence(arr);

        System.out.println(allSeq);

        long count = 0;
        for (ArrayList<Integer> arrayList : allSeq) {
            if (arrayList.size() > 0) {
                if (arrayList.size() == 1) {
                    System.out.println(arrayList);
                    count++;
                } else {
                    if (isValid(arrayList)) {
                        System.out.println(arrayList);
                        count++;
                    }
                }
            }
        }

        return (long) (count % (Math.pow(10, 9) + 7));
    }

    public static ArrayList<ArrayList<Integer>> generateSubsequence(int[] arr) {

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

        return outer;
    }

    public static boolean isValid(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer val : list) {
            sum += val;
        }

        int sumShould = list.size() * list.get(0);
        if (sum != sumShould) {
            return false;
        }

        return true;
    }
}