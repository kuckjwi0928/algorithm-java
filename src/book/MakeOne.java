package book;

import java.util.Arrays;

public class MakeOne {
  public static void main(String[] args) {
    System.out.println(new MakeOne().solution(26));
  }

  public int solution(int n) {
    int[] dp = new int[30001];
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }
      if (i % 5 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 5] + 1);
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[n];
  }
}
