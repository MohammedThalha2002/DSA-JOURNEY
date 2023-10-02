package Algorithms.Recursion.Patterns;

public class PrintStars {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Pattern 1");
        pattern1(0, 0, n);
        System.out.println();
        System.out.println("Pattern 2");
        pattern2(n, 0);
        System.out.println();
        System.out.println("Pattern 3");
        pattern3(n, 0);
        System.out.println("\n");
        System.out.println("Pattern 4");
        pattern4(n, 0);
        System.out.println("");
        System.out.println("Pattern 5");
        pattern5(n, 0);
    }

    // * * * *
    // * * * *
    // * * * *
    // * * * *
    public static void pattern1(int row, int col, int n) {
        // base cond
        if (row == n) {
            return;
        }

        // printing colums
        if (col < n) {
            System.out.print("* ");
            pattern1(row, col + 1, n);
        } else {
            // for printing new row
            System.out.println();
            pattern1(row + 1, 0, n);
        }
    }

    // * * * *
    // * * *
    // * *
    // *
    public static void pattern2(int row, int col) {
        // base cond
        if (row == 0) {
            return;
        }

        // printing colums
        if (col < row) {
            System.out.print("* ");
            pattern2(row, col + 1);
        } else {
            // for printing new row
            System.out.println();
            pattern2(row - 1, 0);
        }
    }

    // *
    // * *
    // * * *
    // * * * *
    public static void pattern3(int row, int col) {
        // base cond
        if (row == 0) {
            return;
        }

        // printing colums
        if (col < row) {
            pattern3(row, col + 1);
            System.out.print("* ");
        } else {
            // for printing new row
            pattern3(row - 1, 0);
            if (row != 1)
                System.out.println();
        }
    }

    //       *
    //     * *
    //   * * *
    // * * * *
    public static void pattern4(int row, int col) {
        int n = row;
        for (int i = 1; i <= n; i++) {
            
            // printing spaces
            for (int j = i; j <= n-1; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // 1
    // 1 2
    // 1 2 3
    // 1 2 3 4
    public static void pattern5(int row, int col) {
        // base cond
        if (row == 0) {
            return;
        }

        // printing colums
        if (col < row) {
            pattern5(row, col + 1);
            System.out.print(col + 1 + " ");
        } else {
            // for printing new row
            pattern5(row - 1, 0);
            if (row != 1)
                System.out.println();
        }
    }
}
