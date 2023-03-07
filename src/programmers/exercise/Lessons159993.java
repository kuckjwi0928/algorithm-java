package programmers.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class Lessons159993 {
  public static void main(String[] args) {
    System.out.println(new Lessons159993().solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    System.out.println(new Lessons159993().solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    System.out.println(new Lessons159993().solution(new String[]{"SOEOL", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}));
  }

  public int solution(String[] maps) {
    final var n = maps.length;
    final var m = maps[0].length();
    final var mark = new int[n][m];
    final var queue = new LinkedList<int[]>();

    var visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (maps[i].charAt(j) == 'S') {
          queue.offer(new int[]{i, j});
          break;
        }
      }
    }

    final var lever = bfs(n, m, queue, mark, maps, visited, 'L');

    if (lever.length == 0) {
      return -1;
    }

    queue.clear();
    queue.offer(lever);
    visited = new boolean[n][m];

    final var exit = bfs(n, m, queue, mark, maps, visited, 'E');

    if (exit.length == 0) {
      return -1;
    }

    return mark[exit[0]][exit[1]];
  }

  private int[] bfs(int n, int m, Queue<int[]> queue, int[][] mark, String[] maps, boolean[][] visited, char findChar) {
    final int[] dx = {-1, 0, 1, 0};
    final int[] dy = {0, 1, 0, -1};
    while (!queue.isEmpty()) {
      final var current = queue.poll();
      if (maps[current[0]].charAt(current[1]) == findChar) {
        return current;
      }
      for (int i = 0; i < 4; i++) {
        final var nx = current[0] + dx[i];
        final var ny = current[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X') {
          continue;
        }
        var c = maps[nx].charAt(ny);
        if (!visited[nx][ny] && (c == 'O' || c == 'S' || c == 'L' || c == 'E')) {
          mark[nx][ny] = mark[current[0]][current[1]] + 1;
          queue.offer(new int[]{nx, ny});
          visited[nx][ny] = true;
        }
      }
    }
    return new int[]{};
  }
}
