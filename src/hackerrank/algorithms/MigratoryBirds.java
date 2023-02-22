package hackerrank.algorithms;

import java.util.List;

public class MigratoryBirds {
  public static void main(String[] args) {
    System.out.println(migratoryBirds(List.of(1, 4, 4, 4, 5, 3)));
  }

  public static int migratoryBirds(List<Integer> arr) {
    int[] counter = new int[6];
    for (int a : arr) {
      counter[a]++;
    }
    var max = Integer.MIN_VALUE;
    var num = -1;
    for (int i = 1; i < counter.length; i++) {
      if (max < counter[i]) {
        max = counter[i];
        num = i;
      }
    }
    return num;
  }
}
