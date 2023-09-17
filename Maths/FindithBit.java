package Maths;

public class FindithBit {
    public static void main(String[] args) {
        // find the i'th bit of a number
        // => 67 -> 1000011; the 2nd bit is 1
        int n = 67;
        int i = 7;
        int res = findithBit(n, i);
        System.out.println(res);
    }

    private static int findithBit(int n, int i) {
        // 1) create a val with i pos as 1 and remainig as zero
        // 2) This can be done using left shiting the 1 i-1 times
        // 3) then AND the n with val to get the res
        int val = 1 << (i - 1); // left shifting
        int bit = n & val; // 10
        return bit >> (i - 1); // right shifting to get only the digit
    }
}
