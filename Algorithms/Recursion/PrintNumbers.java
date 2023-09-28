package Algorithms.Recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        // print next five numbers using recursion
        // print(1);
        // print 1 to N
        oneToN(5);
    }

    static void print(int n) {
        // base condition - where the program stops or where the body differes from
        // others
        if (n > 5) {
            return;
        }

        // normal condition
        System.out.println(n);
        print(n + 1);
    }

    static void oneToN(int n){
        if(n == 0){
            return;
        }

        oneToN(n-1); // => oneToN(4) => oneToN(3) => oneToN(2) => oneToN(1) => oneToN(0)
        System.out.println(n);
    }
}
