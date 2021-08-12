package leetcode;

import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {
    System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    int len = nums.length;

    if (len < 1) {
      return Collections.emptyList();
    }

    Arrays.sort(nums);

    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < len; i++) {
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum > 0) {
          k--;
        } else if (sum < 0) {
          j++;
        } else {
          list.add(List.of(nums[i], nums[j], nums[k]));
          j++;
          k--;
        }
      }
    }

    return List.copyOf(new HashSet<>(list));
  }
}
