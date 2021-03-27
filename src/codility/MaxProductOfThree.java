package codility;

import java.util.Arrays;

public class MaxProductOfThree {
  public static void main(String[] args) {
    System.out.println(MaxProductOfThree.solution(new int[]{-3, 1, 2, -2, 5, 6}));
  }

  public static int solution(int[] A) {
    Arrays.sort(A);
    int len = A.length;
    int a = A[len - 1] * A[len - 2] * A[len - 3];
    int b = A[len - 1] * A[0] * A[1];
    return Math.max(a, b);
  }
}
