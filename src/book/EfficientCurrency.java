package book;

import java.util.Arrays;

public class EfficientCurrency {
  public static void main(String[] args) {
    System.out.println(new EfficientCurrency().solution(2, 15, new int[]{2, 3}));
    System.out.println(new EfficientCurrency().solution(3, 4, new int[]{3, 5, 7}));
  }

  public int solution(int N, int M, int[] arr) {
    int[] dp = new int[M + 1];
    Arrays.fill(dp, 10001);
    dp[0] = 0;
    for (int i = 0; i < N; i++) {
      for (int j = arr[i]; j < M + 1; j++) {
        if (dp[j - arr[i]] != 10001) {
          dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
        }
      }
    }
    return dp[M] == 10001 ? -1 : dp[M];
  }
}
