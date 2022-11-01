package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
  public static void main(String[] args) {
    System.out.println(new SubarraySum().subarraySum(new int[]{1,1,1}, 2));
    System.out.println(new SubarraySum().subarraySum(new int[]{1,2,3}, 3));
    System.out.println(new SubarraySum().subarraySum(new int[]{1}, 1));
  }

  public int subarraySum(int[] nums, int k) {
    int sum = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      count += map.getOrDefault(sum - k, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
