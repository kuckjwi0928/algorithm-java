package boj;

import java.util.Scanner;

public class Solution1149 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();

      sc.nextLine();

      int[][] arr = new int[N][3];

      for (int i = 0; i < N; i++) {
        int red = sc.nextInt();
        int green = sc.nextInt();
        int blue = sc.nextInt();

        if (i == 0) {
          arr[i][0] = red;
          arr[i][1] = green;
          arr[i][2] = blue;
          continue;
        }

        arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + red;
        arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + green;
        arr[i][2] = Math.min(arr[i - 1][1], arr[i - 1][0]) + blue;
      }

      System.out.println(Math.min(Math.min(arr[N - 1][0], arr[N - 1][1]), arr[N - 1][2]));
    }
  }
}
