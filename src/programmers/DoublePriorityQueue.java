package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class DoublePriorityQueue {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new DoublePriorityQueue().solution(new String[]{"I 16", "D 1"})));
    System.out.println(Arrays.toString(new DoublePriorityQueue().solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
  }

  public int[] solution(String[] operations) {
    int[] answer = new int[]{0, 0};
    LinkedList<Integer> queue = new LinkedList<>();

    for (String operation : operations) {
      String[] splits = operation.split("\\s");
      int num = Integer.parseInt(splits[1]);

      if ("I".equals(splits[0])) {
        queue.add(num);
        Collections.sort(queue);
        continue;
      }

      if (queue.isEmpty()) {
        continue;
      }

      if (num > 0) {
        queue.removeLast();
      } else {
        queue.removeFirst();
      }
    }

    if (!queue.isEmpty()) {
      answer[0] = queue.getLast();
      answer[1] = queue.getFirst();
    }

    return answer;
  }
}
