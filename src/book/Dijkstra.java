package book;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
  private static final int INF = 1_000_000_000;

  public static void main(String[] args) {
    final var nodes = new Node[][]{
            {},
            {new Node(2, 2), new Node(3, 5), new Node(4, 1)},
            {new Node(3, 3), new Node(4, 2)},
            {new Node(2, 3), new Node(6, 5)},
            {new Node(3, 3), new Node(5, 1)},
            {new Node(3, 1), new Node(6, 2)},
            {},
    };
    final var distance = new int[nodes.length + 1];
    Arrays.fill(distance, INF);
    new Dijkstra().dijkstra(nodes, distance, 1);
    for (int i : distance) {
      if (i == INF) {
        continue;
      }
      System.out.println(i);
    }
  }

  private static class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  public void dijkstra(Node[][] graph, int[] distance, int start) {
    final var queue = new PriorityQueue<Node>();
    queue.add(new Node(start, 0));
    distance[start] = 0;
    while (!queue.isEmpty()) {
      final var current = queue.poll();
      if (distance[current.index] < current.cost) {
        continue;
      }
      for (int i = 0; i < graph[current.index].length; i++) {
        final var nextNode = graph[current.index][i];
        final var cost = current.cost + nextNode.cost;
        if (cost < distance[nextNode.index]) {
          distance[nextNode.index] = cost;
          queue.offer(new Node(nextNode.index, cost));
        }
      }
    }
  }
}
