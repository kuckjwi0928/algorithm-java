package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
  public static void main(String[] args) {
    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4}, 1));
    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,0,0}, 1));
    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,0}, -100));
  }

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int len = nums.length;
    int min = Integer.MAX_VALUE;
    int sum = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < len - 2; i++) {
      int j = i + 1;
      int k = len - 1;

      while (j < k) {
        int calc = nums[i] + nums[j] + nums[k];
        int diff = Math.abs(target - calc);

        if (diff < min) {
          min = diff;
          sum = calc;
        }

        if (calc < target) {
          j++;
        } else if (calc > target) {
          k--;
        } else {
          break;
        }
      }
    }

    return sum;
  }
}
