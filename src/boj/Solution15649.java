package boj;

import java.util.Scanner;

public class Solution15649 {

  private static int[] arr;
  private static boolean[] visited;

  public static void main(String[] args) {
    int n, m;

    try (Scanner scanner = new Scanner(System.in)) {
      n = scanner.nextInt();
      m = scanner.nextInt();
    }

    arr = new int[n];
    visited = new boolean[n];

    dfs(0, n, m);
  }

  public static void dfs(int index, int n, int m) {
    if (index == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
    for(int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[index] = i + 1;
        dfs(index + 1, n, m);
        visited[i] = false;
      }
    }
  }
}
