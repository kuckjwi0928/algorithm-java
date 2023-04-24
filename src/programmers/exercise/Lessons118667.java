package programmers.exercise;

import java.util.LinkedList;

public class Lessons118667 {
  public static void main(String[] args) {
    System.out.println(new Lessons118667().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    System.out.println(new Lessons118667().solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
    System.out.println(new Lessons118667().solution(new int[]{1, 1}, new int[]{1, 5}));
  }

  public int solution(int[] arr1, int[] arr2) {
    long queue1Sum = 0;
    long queue2Sum = 0;

    var queue1 = new LinkedList<Integer>();
    var queue2 = new LinkedList<Integer>();

    for (var i = 0; i < arr1.length; i++) {
      queue1Sum += arr1[i];
      queue2Sum += arr2[i];
      queue1.add(arr1[i]);
      queue2.add(arr2[i]);
    }

    var limit = queue1.size() * 2;
    var count = 0;

    if ((queue1Sum + queue2Sum) % 2 != 0) {
      return -1;
    }

    while (count / 2 < limit) {
      if (queue1Sum == queue2Sum) {
        return count;
      }
      if (queue1Sum < queue2Sum) {
        var q2 = queue2.poll();
        queue1.offer(q2);
        queue1Sum += q2;
        queue2Sum -= q2;
        count++;
      } else {
        var q1 = queue1.poll();
        queue2.offer(q1);
        queue1Sum -= q1;
        queue2Sum += q1;
        count++;
      }
    }

    return -1;
  }
}
