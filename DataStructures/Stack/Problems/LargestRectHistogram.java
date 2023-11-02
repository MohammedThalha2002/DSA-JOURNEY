package DataStructures.Stack.Problems;

public class LargestRectHistogram {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 33 };
        int maxRect = findMaxRect(arr);
        System.out.println(maxRect);
    }

    private static int findMaxRect(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                int sum = 0;
                int moves = -1;
                // System.out.println("Value : " + arr[j]);
                // left move
                for (int left = j; left >= 0 && arr[j] <= arr[left]; left--) {
                    moves++;
                }
                // right move
                for (int right = j; right <= i && arr[j] <= arr[right]; right++) {
                    moves++;
                }

                sum = arr[j] * moves;
                // System.out.println("Moves : " + moves);
                // System.out.println("Sum : " + sum);
                max = Math.max(max, sum);
            }

        }

        return max;
    }
}
