package codility.lesson;

import java.util.Arrays;

public class PermCheck {
  public static void main(String[] args) {
    System.out.println(PermCheck.solution(new int[]{4,1,3,2}));
    System.out.println(PermCheck.solution(new int[]{4,1,3}));
  }
  private static int solution(int[] A) {
    int len = A.length;
    Arrays.sort(A);
    if (A[0] != 1) {
      return 0;
    }
    for (int i = 0; i < len; i++) {
      if (i + 1 != len && A[i+1] - A[i] != 1) {
        return 0;
      }
    }
    return 1;
  }
}
