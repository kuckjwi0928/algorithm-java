package book;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
  private static final int INF = 1000000000;

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      var n = scanner.nextInt();
      var m = scanner.nextInt();
      var graph = new int[n + 1][n + 1];
      for (var i = 0; i < n + 1; i++) {
        Arrays.fill(graph[i], INF);
      }
      for (var i = 1; i < n + 1; i++) {
        for (var j = 1; j < n + 1; j++) {
          if (i == j) {
            graph[i][j] = 0;
          }
        }
      }
      for (var i = 0; i < m; i++) {
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var c = scanner.nextInt();
        graph[a][b] = c;
      }
      for (var k = 1; k < n + 1; k++) {
        for (var i = 1; i < n + 1; i++) {
          for (var j = 1; j < n + 1; j++) {
            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
          }
        }
      }
      for (var i = 1; i < n + 1; i++) {
        for (var j = 1; j < n + 1; j++) {
          if (graph[i][j] == INF) {
            System.out.print("INFINITY ");
          } else {
            System.out.print(graph[i][j] + " ");
          }
        }
        System.out.println();
      }
    }
  }
}
