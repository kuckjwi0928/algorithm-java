package codility.lesson;

import java.util.Stack;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
public class Nesting {
  public static void main(String[] args) {
    var obj = new Nesting();
    System.out.println(obj.solution("(()(())())"));
    System.out.println(obj.solution("())"));
  }

  public int solution(String S) {
    var chars = S.toCharArray();
    var stack = new Stack<Character>();

    for (final var c : chars) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
        } else {
          return 0;
        }
      }
    }

    return stack.isEmpty() ? 1 : 0;
  }
}
