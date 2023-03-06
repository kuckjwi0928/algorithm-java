package programmers.exercise;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/138477
public class Lessons138477 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons138477().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    System.out.println(Arrays.toString(new Lessons138477().solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
  }

  public int[] solution(int k, int[] score) {
    var priorityQueue = new PriorityQueue<Integer>();
    var results = new int[score.length];
    var resultIndex = 0;
    for (int s : score) {
      if (priorityQueue.size() < k) {
        priorityQueue.offer(s);
      } else if (priorityQueue.peek() < s) {
        priorityQueue.poll();
        priorityQueue.offer(s);
      }
      results[resultIndex++] = priorityQueue.peek();
    }
    return results;
  }
}
