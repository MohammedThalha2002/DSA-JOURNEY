package DataStructures.Trees.Theory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trees tree = new Trees();
        tree.populate(sc);
        tree.display();
        sc.close();
    }
}
