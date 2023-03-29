package programmers.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class Lessons169199 {
  public static void main(String[] args) {
    System.out.println(new Lessons169199().solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    System.out.println(new Lessons169199().solution(new String[]{".D.R", "....", ".G..", "...D"}));
  }

  public int solution(String[] board) {
    final var dx = new int[]{-1, 1, 0, 0};
    final var dy = new int[]{0, 0, -1, 1};
    final var visited = new boolean[board.length][board[0].length()];
    final var mark = new int[board.length][board[0].length()];

    Queue<int[]> queue = new LinkedList<>();

    var goal = new int[2];

    for (var i = 0; i < board.length; i++) {
      for (var j = 0; j < board[0].length(); j++) {
        if (board[i].charAt(j) == 'R') {
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
        } else if (board[i].charAt(j) == 'G') {
          goal = new int[]{i, j};
        }
      }
    }

    while (!queue.isEmpty()) {
      final var point = queue.poll();
      final var x = point[0];
      final var y = point[1];

      if (x == goal[0] && y == goal[1]) {
        return mark[goal[0]][goal[1]];
      }

      for (var i = 0; i < 4; i++) {
        var nx = x;
        var ny = y;

        while (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length() && board[nx].charAt(ny) != 'D') {
          nx += dx[i];
          ny += dy[i];
        }

        nx -= dx[i];
        ny -= dy[i];

        if (visited[nx][ny]) {
          continue;
        }

        mark[nx][ny] = mark[x][y] + 1;
        visited[nx][ny] = true;
        queue.offer(new int[]{nx, ny});
      }
    }

    return -1;
  }
}
