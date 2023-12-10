public class CountNonMatchingElements {

  public static int solution(int[] numbers) {
    int count = 0;
    int firstElement = numbers[0];
    int secondElement = numbers[1];
    for (int i = 2; i < numbers.length; i++) {
      if (numbers[i] != firstElement && numbers[i] != secondElement) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] numbers = {4, 3, 2, 3, 2, 5, 4, 3};
    int nonMatchingElements = solution(numbers);
    System.out.println("Number of non-matching elements: " + nonMatchingElements);
  }
}
