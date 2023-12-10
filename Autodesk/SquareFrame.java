import java.util.Arrays;

public class SquareFrame {

    static String[] squareFrame(int rows) {
        String[] arr = new String[rows];

        String pattern = "*";
        String empty = " ";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 || i == rows - 1) {
                    arr[i] = pattern.repeat(rows);
                } else if (j == 0 || j == rows - 1) {
                    arr[i] = "*" + empty.repeat(rows - 2) + "*";
                }
            }
        }

        return arr;
    }

    public static void main(String args[]) {

        int rows = 8;
        String[] arr = squareFrame(rows);
        System.out.println(Arrays.toString(arr));
    }
}