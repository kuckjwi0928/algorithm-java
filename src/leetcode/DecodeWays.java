package leetcode;

import java.util.Arrays;

public class DecodeWays {
  public static void main(String[] args) {
    System.out.println(new DecodeWays().numDecodings("226"));
  }

  public int numDecodings(String s) {
    var n = s.length();
    var dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) - '0' == 0 ? 0 : 1;
    for (int i = 2; i <= n; i++) {
      var prev = s.charAt(i - 2) - '0';
      var current = s.charAt(i - 1) - '0';
      var digit = 10 * prev + current;
      if (current >= 1 && current <= 9) {
        dp[i] += dp[i - 1];
      }
      if (digit >= 10 && digit <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[n];
  }
}
