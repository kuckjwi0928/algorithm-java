package hackerrank.kits;

import java.util.List;

public class PlusMinus {
  public static void main(String[] args) {
    plusMinus(List.of(1, 1, 0, -1, -1));
  }

  public static void plusMinus(List<Integer> arr) {
    int positive = 0;
    int negative = 0;
    int zero = 0;

    for (int i : arr) {
      if (i > 0) {
        positive++;
      } else if (i == 0) {
        zero++;
      } else {
        negative++;
      }
    }

    int size = arr.size();

    System.out.printf("%.6f%n", (double) positive / size);
    System.out.printf("%.6f%n", (double) negative / size);
    System.out.printf("%.6f%n", (double) zero / size);
  }
}
