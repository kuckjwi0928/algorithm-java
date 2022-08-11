package boj;

import java.util.Scanner;

public class Solution2579 {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int[] dp = new int[300];
      int[] arr = new int[300];
      int n = scan.nextInt();
      for (int i = 0; i < n; i++) {
        arr[i] = scan.nextInt();
      }

      dp[0] = arr[0];
      dp[1] = arr[0] + arr[1];
      dp[2] = arr[2] + Math.max(arr[0], arr[1]);

      for (int i = 3; i < n; i++) {
        dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
      }

      System.out.println(dp[n - 1]);
    }
  }
}
