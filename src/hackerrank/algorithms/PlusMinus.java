package hackerrank.algorithms;

import java.util.List;

public class PlusMinus {
  public static void main(String[] args) {
    plusMinus(List.of(-4, 3, -9, 0, 4, 1));
  }

  public static void plusMinus(List<Integer> arr) {
    var positive = 0;
    var negative = 0;
    var zero = 0;

    for (final var i : arr) {
      if (i == 0) {
        zero++;
      } else if (i > 0) {
        positive++;
      } else {
        negative++;
      }
    }

    final var size = arr.size() + 0.0d;

    System.out.printf("%6f\n", positive / size);
    System.out.printf("%6f\n", negative / size);
    System.out.printf("%6f\n", zero / size);
  }
}
