package Algorithms.Recursion;

public class CountSteps {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countSteps(n));
    }

    private static int countSteps(int n) {
        if(n < 2){
            return 1;
        }
        return countSteps(n-1) + countSteps(n-2);
    }
}
