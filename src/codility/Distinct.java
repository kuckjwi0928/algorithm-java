package codility;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Distinct {
  public static void main(String[] args) {
    System.out.println(Distinct.solution(new int[]{2, 1, 1, 2, 3, 1}));
  }
  public static int solution(int[] A) {
    return Arrays.stream(A).boxed().collect(Collectors.toSet()).size();
  }
}
