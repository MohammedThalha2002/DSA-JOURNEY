public class TimeMachine {

    public static int solution(int[] years) {
        int totalHours = 0;

        for (int i = 0; i < years.length - 1; i++) {
            int currentYear = years[i];
            int nextYear = years[i + 1];

            if (currentYear == nextYear) {
                totalHours += 0;
            } else if (currentYear < nextYear) {
                totalHours += 1;
            } else {
                totalHours += 2;
            }
        }

        return totalHours;
    }

    public static void main(String[] args) {
        int[] years1 = { 2000, 1990, 2005, 2050 };
        System.out.println(solution(years1)); // Output: 4

        int[] years2 = { 2000, 2021, 2005 };
        System.out.println(solution(years2)); // Output: 3

        int[] years3 = { 2021, 2021, 2005 };
        System.out.println(solution(years3)); // Output: 2
    }
}
