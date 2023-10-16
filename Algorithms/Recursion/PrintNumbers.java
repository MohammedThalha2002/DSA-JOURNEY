package Algorithms.Recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        // print N to 1
        System.out.println("N TO 1");
        nToOne(10);
        // print 1 to N
        System.out.println("\n1 TO N");
        oneToN(10);

    }

    static void nToOne(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            nToOne(n - 1);
        }

        return;
    }

    static void oneToN(int n) {

        if (n > 0) {
            oneToN(n - 1);
            System.out.print(n + " ");
        }

        return;
    }
}
