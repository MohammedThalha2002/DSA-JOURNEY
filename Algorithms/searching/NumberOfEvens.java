package Algorithms.searching;

class NumberOfEvens {
    public static void main(String[] args) {
        int[] arr = { 1, 32, 444, 56, 7777, 0, -42 };
        int count = countEvens(arr);
        System.out.println(count);
    }

    public static int countEvens(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (evenOptimized(num)) {
                count++;
            }
        }
        return count;
    }

    // normal method
    public static boolean even(int num) {
        int len = 0;

        if (num < 0)
            num = num * -1;

        if (num == 0)
            return false;

        while (num > 0) {
            len++;
            num /= 10;
        }

        return len % 2 == 0;
    }

    // Optimum method
    public static boolean evenOptimized(int num) {
        if (num < 0)
            num *= -1;

        int res = (int) (Math.log10(num)) + 1;

        return res % 2 == 0;
    }
}