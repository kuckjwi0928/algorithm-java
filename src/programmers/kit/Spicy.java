package programmers.kit;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Spicy {
  public static void main(String[] args) {
    new Spicy().solution(new int[]{1,1,1}, 7);
  }
  public int solution(int[] scoville, int K) {
    PriorityQueue<Integer> queue = Arrays.stream(scoville)
            .boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));

    int shuffle = 0;

    while (!queue.isEmpty() && queue.peek() <= K) {
      if (queue.size() < 2) {
        return -1;
      }

      int n1 = queue.poll();
      int n2 = queue.poll();

      queue.offer(n1 + n2 * 2);

      shuffle++;
    }

    return shuffle > 0 ? shuffle : -1;
  }
}
