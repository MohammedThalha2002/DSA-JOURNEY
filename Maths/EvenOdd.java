package Maths;

public class EvenOdd {
    public static void main(String[] args) {
        // check the binary digit is even or odd without using the remainder operation
        int val = 62414237;
        isOddorEven(val);
    }

    private static void isOddorEven(int val) {
        // as binary's last number determines the odd or even of a number
        // using AND operation with 1 will give zero if it is EVEN or one if it is ODD
        if ((val&1) == 1) {
            System.out.println("ODD");
        } else {
            System.out.println("Even");
        }
    }
}
