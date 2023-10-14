package Algorithms.searching;

public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] arr = { 'c', 'f', 'j' };
        char ceil = 'f';
        char res = nextGreatestLetter(arr, ceil);
        System.out.println("The ceil of the character from the array is " + res);
    }

    public static char nextGreatestLetter(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (start + 1 == arr.length)
            return arr[0];
        else
            return arr[start + 1];

    }
}
