package leetcode;

import java.util.HashMap;

public class SingleNumber {
  public static void main(String[] args) {
    new SingleNumber().singleNumber(new int[]{2,2,1});
  }

  public int singleNumber(int[] nums) {
    final var map = new HashMap<Integer, Integer>();
    for (final var num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (final var entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
