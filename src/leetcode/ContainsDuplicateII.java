package leetcode;

import java.util.HashSet;

public class ContainsDuplicateII {
  public static void main(String[] args) {
    System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    var set = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) return true;
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
  }
}
