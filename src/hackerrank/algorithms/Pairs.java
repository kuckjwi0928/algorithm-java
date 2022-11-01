package hackerrank.algorithms;

import java.util.*;

public class Pairs {
  public static void main(String[] args) {
    System.out.println(pairs(2, new ArrayList<>(List.of(1, 5, 3, 4, 2))));
    System.out.println(pairs(2, new ArrayList<>(List.of(1, 3, 5, 8, 6, 4, 2))));
  }

  public static int pairs(int k, List<Integer> arr) {
    int count = 0;
    Collections.sort(arr);

    Map<Integer, Integer> map = new HashMap<>();
    for (Integer integer : arr) {
      if (map.containsKey(integer - k)) {
        count++;
      }
      map.put(integer, map.getOrDefault(integer, 1));
    }

    return count;
  }
}
