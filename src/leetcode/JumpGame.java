package leetcode;

public class JumpGame {
  public static void main(String[] args) {
    System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
  }

  public boolean canJump(int[] nums) {
    int[] dp = new int[nums.length + 1];
    dp[0] = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (dp[i] < i) {
        return false;
      }
      dp[i + 1] = Math.max(dp[i], i + nums[i]);
    }
    return true;
  }
}
