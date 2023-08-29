package codility.lesson;

import java.util.Stack;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
public class Fish {
  public static void main(String[] args) {
    var obj = new Fish();
    System.out.println(obj.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
  }

  public int solution(int[] A, int[] B) {
    var stack = new Stack<Integer>();
    var alive = 0;
    for (var i = 0; i < A.length; i++) {
      if (B[i] == 1) {
        stack.push(A[i]);
      } else {
        while (!stack.isEmpty()) {
          if (stack.peek() > A[i]) {
            break;
          } else {
            stack.pop();
          }
        }
        if (stack.isEmpty()) {
          alive++;
        }
      }
    }
    return alive + stack.size();
  }
}
