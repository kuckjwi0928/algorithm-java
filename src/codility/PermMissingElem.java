package codility;

import java.util.Arrays;

public class PermMissingElem {
  public static void main(String[] args) {
    System.out.println(PermMissingElem.solution(new int[]{2, 3, 1, 5}));
  }
  private static int solution(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
      if (i + 1 != A[i]) {
        return i + 1;
      }
    }
    return A.length + 1;
  }
}
