package boj;

import java.util.*;

public class Solution2178 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      sc.nextLine();
      int[][] nums = new int[n][m];
      for (int i = 0; i < n; i++) {
        String[] line = sc.nextLine().split("");
        for (int j = 0; j < m; j++) {
          nums[i][j] = Integer.parseInt(line[j]);
        }
      }
      solution(nums);
      System.out.println(nums[n - 1][m - 1]);
    }
  }

  public static void solution(int[][] nums) {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    Queue<List<Integer>> queue = new LinkedList<>();

    queue.offer(List.of(0, 0));

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
