package DataStructures.LinkedList.Problems;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(isHappyNum(n));
    }

    private static boolean isHappyNum(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquares(slow);
            fast = findSquares(findSquares(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }

        return false;
    }

    public static int findSquares(int n) {
        int squ = 0;
        while (n > 0) {
            int rem = n % 10;
            squ += rem * rem;
            n /= 10;
        }
        return squ;
    }
}
