package programmers.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Lessons154540 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons154540().solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"})));
    System.out.println(Arrays.toString(new Lessons154540().solution(new String[]{"XXX","XXX","XXX"})));
  }

  public int[] solution(String[] maps) {
    final var dx = new int[]{-1, 0, 1, 0};
    final var dy = new int[]{0, 1, 0, -1};
    final var visited = new boolean[maps.length][maps[0].length()];

    int[] area;

    var list = new ArrayList<Integer>();

    while ((area = findArea(maps, visited)) != null) {
      var queue = new LinkedList<int[]>();
      queue.offer(area);
      var sum = 0;
      while (!queue.isEmpty()) {
        final var current = queue.poll();
        final var x = current[0];
        final var y = current[1];
        if (maps[x].charAt(y) != 'X' && !visited[x][y]) {
          sum += maps[x].charAt(y) - '0';
          visited[x][y] = true;
        }
        for (int i = 0; i < 4; i++) {
          final var nx = x + dx[i];
          final var ny = y + dy[i];
          if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length() || maps[nx].charAt(ny) == 'X' || visited[nx][ny]) {
            continue;
          }
          sum += maps[nx].charAt(ny) - '0';
          visited[nx][ny] = true;
          queue.offer(new int[]{nx, ny});
        }
      }
      list.add(sum);
    }

    if (list.isEmpty()) {
      return new int[]{-1};
    }

    return list.stream()
            .sorted()
            .mapToInt(Integer::intValue).toArray();
  }

  private int[] findArea(String[] maps, boolean[][] visited) {
    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }
}
