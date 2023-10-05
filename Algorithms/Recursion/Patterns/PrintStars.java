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
}
