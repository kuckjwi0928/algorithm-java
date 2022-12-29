package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  public static void main(String[] args) {
    System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
  }

  public List<String> summaryRanges(int[] nums) {
    final var result = new ArrayList<String>();
    if (nums.length == 0) {
      return result;
    }
    var start = nums[0];
    var end = nums[0];
    for (var i = 1; i < nums.length; i++) {
      if (nums[i] != end + 1) {
        result.add(start == end ? String.valueOf(start) : start + "->" + end);
        start = nums[i];
      }
      end = nums[i];
    }
    result.add(start == end ? String.valueOf(start) : start + "->" + end);
    return result;
  }
}
