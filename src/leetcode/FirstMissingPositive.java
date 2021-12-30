package leetcode;

import java.util.Arrays;

public class FirstMissingPositive {
  public static void main(String[] args) {
    System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1,2,0}));
    System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
    System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{7,8,9,11,12}));
    System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2, 1}));
  }

  public int firstMissingPositive(int[] nums) {
    Arrays.sort(nums);
    int min = 1;
    for (int num : nums) {
      if (num == min) {
        min++;
      }
    }
    return min;
  }
}
