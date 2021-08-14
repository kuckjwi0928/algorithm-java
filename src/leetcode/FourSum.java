package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
  public static void main(String[] args) {
    System.out.println(new FourSum().fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    System.out.println(new FourSum().fourSum(new int[]{2,2,2,2,2}, 8));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);

    int len = nums.length;

    Set<List<Integer>> set = new LinkedHashSet<>();

    for (int i = 0; i < len - 3; i++) {
      for (int j = i + 1; j < len - 2; j++) {
        int left = j + 1;
        int right = len - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            set.add(List.of(nums[i], nums[j], nums[left], nums[right]));
            left++;
            right--;
          }
        }
      }
    }

    return new LinkedList<>(set);
  }
}
