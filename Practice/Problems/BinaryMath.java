package Practice.Problems;

public class BinaryMath {
    public static void main(String[] args) {
        // A - AND
        // B - OR
        // C - NOT
        String str = "1C0C1C1A0A0";
        int res = 0;
        int first = str.charAt(0) - 48;

        for (int i = 1; i < str.length() - 1; i+=2) {
            int sec = str.charAt(i + 1) - 48;
            char op = str.charAt(i);

            if (op == 'A') {
                res = first & sec;
            } else if (op == 'B') {
                res = first | sec;
            } else {
                res = first ^ sec;
            }
            first = res;
        }

        System.out.println(res);
    }
}
