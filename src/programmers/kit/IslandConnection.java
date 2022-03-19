package programmers.kit;

import java.util.Arrays;
import java.util.Comparator;

public class IslandConnection {
  public static void main(String[] args) {
    System.out.println(new IslandConnection().solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
  }

  public int solution(int n, int[][] costs) {
    Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

    int[] parents = new int[n];

    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

    int distance = 0;

    for (int[] cost : costs) {
      if (union(cost[0], cost[1], parents)) {
        distance += cost[2];
      }
    }

    return distance;
  }

  public int find(int n, int[] parents) {
    if (n == parents[n]) {
      return n;
    }
    return parents[n] = find(parents[n], parents);
  }

  public boolean union(int c, int v, int[] parents) {
    int a = find(c, parents);
    int b = find(v, parents);

    if (a == b) {
      return false;
    }

    if (a > b) {
      parents[a] = b;
      return true;
    }

    parents[b] = a;

    return true;
  }
}
