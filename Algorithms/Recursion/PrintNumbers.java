package Algorithms.Recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        // print next five numbers using recursion
        print(1);
        int a = 10;
        System.out.println(a * a--);
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
}
