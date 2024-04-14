package programmers.exercise;

import java.util.PriorityQueue;

public class Lessons142085 {
  public static void main(String[] args) {
    System.out.println(new Lessons142085().solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    System.out.println(new Lessons142085().solution(2, 4, new int[]{3, 3, 3, 3}));
  }

  public int solution(int n, int k, int[] enemy) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
    for (int i = 0; i < enemy.length; i++) {
      queue.offer(enemy[i]);
      if (queue.size() > k) {
        int value = queue.poll();
        if (value > n) {
          return i;
        }
        n -= value;
      }
    }
    return enemy.length;
  }
}
