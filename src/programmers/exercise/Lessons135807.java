package programmers.exercise;

import java.util.Arrays;

public class Lessons135807 {
  public static void main(String[] args) {
    System.out.println(new Lessons135807().solution(new int[]{10, 17}, new int[]{5, 20}));
    System.out.println(new Lessons135807().solution(new int[]{10, 20}, new int[]{5, 17}));
    System.out.println(new Lessons135807().solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
  }

  public int solution(int[] arrayA, int[] arrayB) {
    Arrays.sort(arrayA);
    Arrays.sort(arrayB);

    var aMax = 0;
    var bMax = 0;

    for (var i = arrayA[arrayA.length - 1]; i > 0; i--) {
      final var value = i;
      if (Arrays.stream(arrayA).allMatch(a -> a % value == 0)
          && Arrays.stream(arrayB).allMatch(b -> b % value != 0)) {
        aMax = value;
        break;
      }
    }

    for (var i = arrayB[arrayB.length - 1]; i > 0; i--) {
      final var value = i;
      if (Arrays.stream(arrayB).allMatch(a -> a % value == 0)
              && Arrays.stream(arrayA).allMatch(b -> b % value != 0)) {
        bMax = value;
        break;
      }
    }

    return Math.max(aMax, bMax);
  }
}
