package book;

public class FloorWork {
  public static void main(String[] args) {
    System.out.println(new FloorWork().solution(3));
  }

  public int solution(int N) {
    int[] dp = new int[1001];
    dp[1] = 1;
    dp[2] = 3;
    for (int i = 3; i <= N; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796;
    }
    return dp[N];
  }
}
