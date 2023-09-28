public class Main {
    public static void main(String[] args) {
        // check(2, {23,45});
        System.out.println(calcSum(3, 4, 2));
    }

    // public static int check(int[] A) {
    // int sum = 0;
    // for (int i = 0; i < A.length; i++) {
    // sum += A[i];
    // }
    // return A.length * sum;
    // }

    public static long calcSum(int N, int X, int Y) {
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % X != 0 && i % Y != 0) {
                sum += i;
            }
        }

        return sum;
    }

}
