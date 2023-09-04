package codility.lesson;

import java.util.Stack;

// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
public class StoneWall {
  public static void main(String[] args) {
    var obj = new StoneWall();
    System.out.println(obj.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
  }

  public int solution(int[] H) {
    var stack = new Stack<Integer>();
    var count = 0;
    for (int height : H) {
      while (!stack.isEmpty() && stack.peek() > height) {
        stack.pop();
      }
      if (stack.isEmpty() || stack.peek() < height) {
        stack.push(height);
        count++;
      }
    }
    return count;
  }
}
