package etc;

import java.util.Arrays;

public class UnionFind {
  private final static int LIMIT = 10;

  public static void main(String[] args) {
    UnionFind unionFind = new UnionFind();
    unionFind.init();
    System.out.println(Arrays.toString(unionFind.getParents()));
    unionFind.union(0, 1);
    unionFind.union(1, 2);
    System.out.println(Arrays.toString(unionFind.getParents()));
  }

  private final int[] parents = new int[LIMIT];

  public void init() {
    for (int i = 0; i < LIMIT; i++) {
      parents[i] = i;
    }
  }

  public int find(int n) {
    if (n == parents[n]) {
      return n;
    }
    return parents[n] = find(parents[n]);
  }

  public void union(int c, int v) {
    int a = find(c);
    int b = find(v);

    if (a == b) {
      return;
    }

    parents[b] = a;
  }

  public int[] getParents() {
    return parents;
  }
}
