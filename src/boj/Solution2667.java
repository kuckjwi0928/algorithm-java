package boj;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2667
public class Solution2667 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      int[][] map = new int[n][n];
      for (int i = 0; i < n; i++) {
        String line = scanner.next();
        for (int j = 0; j < n; j++) {
          map[i][j] = line.charAt(j) - '0';
        }
      }
      int[][] visited = new int[n][n];
      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (map[i][j] == 1 && visited[i][j] == 0) {
            count++;
            dfs(map, visited, i, j, count);
          }
        }
      }
      int[] answer = new int[count];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (visited[i][j] != 0) {
            answer[visited[i][j] - 1]++;
          }
        }
      }
      System.out.println(count);
      Arrays.sort(answer);
      for (int a : answer) {
        System.out.println(a);
      }
    }
  }

  private static void dfs(int[][] map, int[][] visited, int i, int j, int count) {
    if (i < 0 || i >= map.length || j < 0 || j >= map.length) {
      return;
    }
    if (map[i][j] == 0 || visited[i][j] != 0) {
      return;
    }
    visited[i][j] = count;
    dfs(map, visited, i - 1, j, count);
    dfs(map, visited, i + 1, j, count);
    dfs(map, visited, i, j - 1, count);
    dfs(map, visited, i, j + 1, count);
  }
}
