package programmers.kit;

import java.util.*;

public class FeatureDevelop {
  public static void main(String[] args) {
    int[] progresses = new int[]{93, 30, 55};
    int[] speeds = new int[]{1, 30, 5};
    new FeatureDevelop().solution(progresses, speeds);
  }

  public int[] solution(int[] progresses, int[] speeds) {
    final int COMPLETE = 100;

    List<Integer> answers = new ArrayList<>();
    Queue<Integer> costQueue = new LinkedList<>();

    int len = progresses.length;

    for (int i = 0; i < len; i++) {
      int remain = COMPLETE - progresses[i];
      int cost = (int) Math.ceil((double) remain / speeds[i]);
      costQueue.add(cost);
    }

    int count = 1;
    int prev = costQueue.poll();

    while (!costQueue.isEmpty()) {
      int cost = costQueue.poll();
      if (cost <= prev) {
        count++;
        continue;
      }
      answers.add(count);
      prev = cost;
      count = 1;
    }

    answers.add(count);

    return answers.stream().mapToInt(i -> i).toArray();
  }
}
