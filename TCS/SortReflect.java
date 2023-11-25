package TCS;

import java.util.Scanner;

public class SortReflect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input reading
        String[] inputA = scanner.nextLine().split(" ");
        String[] inputB = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        int[] A = new int[inputA.length];
        int[] B = new int[inputB.length];

        for (int i = 0; i < inputA.length; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }

        // Function call
        selectionSortAndReflect(A, B, n);

        // Output
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]);
            if (i != B.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void selectionSortAndReflect(int[] A, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap elements in array A
            int tempA = A[i];
            A[i] = A[minIndex];
            A[minIndex] = tempA;

            // Reflect the swap in array B
            int tempB = B[i];
            B[i] = B[minIndex];
            B[minIndex] = tempB;
        }
    }
}
