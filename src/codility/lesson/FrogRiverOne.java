package codility.lesson;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
  public static void main(String[] args) {
    System.out.println(FrogRiverOne.solution(5, new int[]{1,3,1,4,2,3,5,4}));
  }
  public static int solution(int X, int[] A) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < A.length; i++) {
      set.add(A[i]);
      if (set.size() == X) {
        return i;
      }
    }
    return -1;
  }
}
