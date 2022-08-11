package boj;

import java.util.Scanner;

public class Solution1018 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int min = Integer.MAX_VALUE;

      char[][] arr = new char[m][n];

      for (int i = 0; i < m; i++) {
        arr[i] = sc.next().toCharArray();
      }

      for (int i = 0; i < m - 7; i++) {
        for (int j = 0; j < n - 7; j++) {
          int b = 0;
          int w = 0;
          for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
              boolean even = (k + l) % 2 == 0;
              if (even && arr[k][l] == 'B') {
                w++;
              } else if (even && arr[k][l] == 'W') {
                b++;
              } else if (!even && arr[k][l] == 'B') {
                b++;
              } else {
                w++;
              }
            }
          }
          min = Math.min(min, Math.min(b, w));
        }
      }

      System.out.println(min);
    }
  }
}
