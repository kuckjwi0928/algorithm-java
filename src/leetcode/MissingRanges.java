package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
  public static void main(String[] args) {
    System.out.println(new MissingRanges().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
  }

  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    var result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      result.add(List.of(lower, upper));
      return result;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        if (nums[i] > lower) {
          result.add(List.of(lower, nums[i] - 1));
        }
      } else {
        if (nums[i] - nums[i - 1] > 1) {
          result.add(List.of(nums[i - 1] + 1, nums[i] - 1));
        }
      }
    }
    if (nums[nums.length - 1] < upper) {
      result.add(List.of(nums[nums.length - 1] + 1, upper));
    }
    return result;
  }
}
