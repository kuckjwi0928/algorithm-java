package codility.lesson;

import java.util.Arrays;

public class NumberOfDiscIntersections {
  public static void main(String[] args) {
    solution(new int[]{1, 5, 2, 1, 4, 0});
  }

  public static int solution(int[] A) {
    int len = A.length;

    long[] lower = new long[len];
    long[] upper = new long[len];

    for (int i = 0; i < A.length; i++) {
      lower[i] = i + A[i] * -1;
      upper[i] = i + A[i];
    }

    Arrays.sort(lower);
    Arrays.sort(upper);

    int intersection = 0;
    int j = 0;

    for (int i = 0; i < len; i++) {
      while (j < len && upper[i] >= lower[j]) {
        intersection += j;
        intersection -= i;
        j++;
      }
    }

    if (intersection > 10_000_000) {
      return -1;
    }

    return intersection;
  }
}
