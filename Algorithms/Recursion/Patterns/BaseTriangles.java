package Algorithms.Recursion.Patterns;

public class BaseTriangles {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Base Traingle 1");
        baseTraingle1(n);
        System.out.println();
        System.out.println("Base Traingle 2");
        baseTraingle2(n);
        System.out.println();
        System.out.println("Star");
        printStar(n);
    }

    // *
    // * *
    // * * *
    // * * * *
    public static void baseTraingle1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * * * *
    // * * *
    // * *
    // *
    public static void baseTraingle2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // using the above two traingles we can build any traingles
    // EXAMPLE
    // *
    // * *
    // * * *
    // * * * *
    // * * *
    // * *
    // *

    public static void printStar(int n) {
        n = n + 1;
        // top portion
        for (int i = 1; i <= n; i++) {
            // left spaces
            // _ _ _ _
            // _ _ _
            // _ _
            // _
            for (int j = i; j <= n; j++) {
                System.out.print("  ");
            }

            // left star
            // *
            // * *
            // * * *
            // * * * *
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // right star
            // *
            // * *
            // * * *
            // * * * *
            for (int j = 2; j <= i; j++) {
                System.out.print("* ");
            }

            // right spaces
            // _ _ _ _
            // _ _ _
            // _ _
            // _
            for (int j = i; j <= n; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
        // bottom portion
        for (int i = 2; i <= n; i++) {
            // left spaces
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            // left stars
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }

            // right stars
            for (int j = i + 1; j <= n; j++) {
                System.out.print("* ");
            }

            // right spaces
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }

            System.out.println();
        }
    }

}
