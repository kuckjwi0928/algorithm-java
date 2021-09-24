package boj;

import java.util.Scanner;

public class Solution1003 {
  private static int[] memo = new int[41];

  public static void main(String[] args) {
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 1;

    try (Scanner sc = new Scanner(System.in)) {
      for (int i = 2; i < memo.length; i++) {
        memo[i] = memo[i - 1] + memo[i - 2];
      }

      int T = sc.nextInt();
      sc.nextLine();

      for (int i = 0; i < T; i++) {
        int N = Integer.parseInt(sc.nextLine());
        if (N == 0) {
          System.out.println("1 0");
        } else if (N == 1) {
          System.out.println("0 1");
        } else {
          System.out.println(memo[N - 1] + " " + memo[N]);
        }
      }
    }
  }
}
