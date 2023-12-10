
public class RobotPath {

    public static int solution(int numRows, int numColumns, int curRow, int curColumn, int[][] laserCoordinates) {
        boolean[][] lasers = new boolean[numRows][numColumns];

        for (int[] laser : laserCoordinates) {
            int laserRow = laser[0] - 1;
            int laserColumn = laser[1] - 1;
            for (int col = 0; col < numColumns; col++) {
                lasers[laserRow][col] = true;
            }
            for (int row = 0; row < numRows; row++) {
                lasers[row][laserColumn] = true;
            }
        }

        int maxSafePath = 0;

        maxSafePath = Math.max(maxSafePath, getMaxSafePath(curRow, curColumn, 0, -1,
                numRows, numColumns, lasers));

        System.out.println("LEFT : " + maxSafePath);

        maxSafePath = Math.max(maxSafePath, getMaxSafePath(curRow, curColumn, 0, 1,
                numRows, numColumns, lasers));
        System.out.println("RIGHT : " + maxSafePath);

        maxSafePath = Math.max(maxSafePath, getMaxSafePath(curRow, curColumn, -1, 0,
                numRows, numColumns, lasers));
        System.out.println("TOP : " + maxSafePath);

        maxSafePath = Math.max(maxSafePath, getMaxSafePath(curRow, curColumn, 1, 0,
                numRows, numColumns, lasers));
        System.out.println("DOWN : " + maxSafePath);

        return maxSafePath;
    }

    private static int getMaxSafePath(int row, int column, int rowDir, int colDir, int numRows, int numColumns,
            boolean[][] lasers) {
        int maxSafePath = 0;

        while (row >= 0 && row < numRows && column >= 0 && column < numColumns &&
                !lasers[row][column]) {
            maxSafePath++;
            row += rowDir;
            column += colDir;
        }

        return maxSafePath - 1;
    }

    public static void main(String[] args) {
        int numRows = 8;
        int numColumns = 8;
        int curRow = 5;
        int curColumn = 3;
        int[][] laserCoordinates = { { 1, 6 }, { 2, 8 } };

        int result = solution(numRows, numColumns, curRow - 1, curColumn - 1, laserCoordinates);
        System.out.println(result); // Output: 3
    }
}
