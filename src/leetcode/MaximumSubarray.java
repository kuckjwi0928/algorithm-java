package leetcode;

public class MaximumSubarray {
  public static void main(String[] args) {
    System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println(new MaximumSubarray().maxSubArray(new int[]{1}));
    System.out.println(new MaximumSubarray().maxSubArray(new int[]{5,4,-1,7,8}));
  }

  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int num : nums) {
      if (sum < 0) {
        sum = 0;
      }
      sum += num;
      max = Math.max(max, sum);
    }
    return max;
  }
}
