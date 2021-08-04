package etc;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DFS {
  private final static int LIMIT = 5;

  private static final String[] vertex = new String[LIMIT];
  private static final List<Integer>[] adj = new LinkedList[LIMIT];
  private static final boolean[] visited = new boolean[LIMIT];

  static {
    for (int i = 0; i < LIMIT; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public static void main(String[] args) {
    vertex[0] = "A";
    vertex[1] = "B";
    vertex[2] = "C";
    vertex[3] = "D";
    vertex[4] = "E";

    adj[0].add(1);
    adj[0].add(2);
    adj[0].add(3);
    adj[1].add(4);

    new DFS().dfs(0);
  }

  public void dfs(int v) {
    System.out.println(vertex[v]);
    visited[v] = true;
    for (int adj : adj[v]) {
      if (!visited[adj]) {
        dfs(adj);
      }
    }
  }
}
