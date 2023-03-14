package programmers.exercise;

import java.util.Arrays;

public class Lessons154538 {
  public static void main(String[] args) {
    System.out.println(new Lessons154538().solution(10, 40, 5));
    System.out.println(new Lessons154538().solution(10, 40, 30));
    System.out.println(new Lessons154538().solution(2, 5, 4));
  }

  public int solution(int x, int y, int n) {
    final var dp = new int[y + 1];
    Arrays.fill(dp, 1_000_001);
    dp[x] = 0;

    for (int i = x; i < y + 1; i++) {
      if (i + n <= y) {
        dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
      }
      if (i * 2 <= y) {
        dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
      }
      if (i * 3 <= y) {
        dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
      }
    }

    return dp[y] == 1_000_001 ? -1 : dp[y];
  }
}
