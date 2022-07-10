package book;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindingMaze {
  public static void main(String[] args) {
    System.out.println(new FindingMaze().solution(new int[][]{{1,0,1,0,1,0},{1,1,1,1,1,1},{0,0,0,0,0,1},{1,1,1,1,1,1},{1,1,1,1,1,1}}));
  }

  public int solution(int[][] nums) {
    int n = nums.length;
    int m = nums[0].length;

    bfs(nums, 0, 0);

    return nums[n - 1][m - 1];
  }

  private void bfs(int[][] nums, int startX, int startY) {
    Queue<List<Integer>> queue = new LinkedList<>();

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    queue.offer(List.of(startX, startY));

    while (!queue.isEmpty()) {
      List<Integer> list = queue.poll();
      int x = list.get(0);
      int y = list.get(1);
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= nums.length || ny < 0 || ny >= nums[0].length || nums[nx][ny] == 0) {
          continue;
        }
        if (nums[nx][ny] == 1) {
          nums[nx][ny] = nums[x][y] + 1;
          queue.offer(List.of(nx, ny));
        }
      }
    }
  }
}
