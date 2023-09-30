package Algorithms.Recursion;

public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(numberOfStepsToReduceANumberToZero(8));
    }

    public static int numberOfStepsToReduceANumberToZero(int num) {
        return helper(num, 0);
    }

    private static int helper(int num, int count) {
        if (num == 0) {
            return count;
        }

        // even => divide by 2
        // odd => sub by 1
        if (num % 2 == 0) {
            return helper(num / 2, ++count);
        } else {
            return helper(num - 1, ++count);
        }
    }

}
