package book;

public class FreezeDrinks {
  public static void main(String[] args) {
    System.out.println(new FreezeDrinks().solution(new int[][]{{0,0,1,1,0},{0,0,0,1,1},{1,1,1,1,1},{0,0,0,0,0}}));
  }

  public int solution(int[][] graph) {
    int count = 0;
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        if (dfs(graph, i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean dfs(int[][] graph, int x, int y) {
    if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) {
      return false;
    }
    if (graph[x][y] == 0) {
      graph[x][y] = 1;
      dfs(graph, x - 1, y);
      dfs(graph, x, y - 1);
      dfs(graph, x + 1, y);
      dfs(graph, x, y + 1);
      return true;
    }
    return false;
  }
}
