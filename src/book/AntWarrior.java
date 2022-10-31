package book;

public class AntWarrior {
  public static void main(String[] args) {
    System.out.println(new AntWarrior().solution(new int[]{1, 3, 1, 5}));
  }

  public int solution(int[] arr) {
    int[] dp = new int[100];
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);
    for (int i = 2; i < arr.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
    }
    return dp[arr.length - 1];
  }
}
