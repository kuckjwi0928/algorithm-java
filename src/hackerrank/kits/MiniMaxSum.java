package hackerrank.kits;

import java.util.Arrays;
import java.util.List;

public class MiniMaxSum {
  public static void main(String[] args) {
    miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
    miniMaxSum(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));
  }

  public static void miniMaxSum(List<Integer> arr) {
    arr.sort(Integer::compareTo);
    long max = 0;
    long min = 0;
    for (int i = 1; i < arr.size(); i++) {
      max += arr.get(i);
    }
    for (int i = 0; i < arr.size() - 1; i++) {
      min += arr.get(i);
    }
    System.out.println(min + " " + max);
  }
}
