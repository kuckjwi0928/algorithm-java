package programmers.exercise;

import java.util.Arrays;
import java.util.Stack;

public class Lessons154539 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Lessons154539().solution(new int[]{2, 3, 3, 5})));
    System.out.println(Arrays.toString(new Lessons154539().solution(new int[]{9, 1, 5, 3, 6, 2})));
  }

  public int[] solution(int[] numbers) {
    final var stack = new Stack<Integer>();
    final var answer = new int[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
    return answer;
  }
}
