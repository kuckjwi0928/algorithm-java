package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution10828 {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int N = Integer.parseInt(reader.readLine());
      Stack<Integer> stack = new Stack<>();
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < N; i++) {
        String[] actions = reader.readLine().split(" ");
        switch (actions[0]) {
          case "push":
            stack.push(Integer.parseInt(actions[1]));
            break;
          case "pop":
            builder.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            break;
          case "top":
            builder.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            break;
          case "empty":
            builder.append(stack.isEmpty() ? 1 : 0).append('\n');
            break;
          case "size":
            builder.append(stack.size()).append('\n');
            break;
          default:
            break;
        }
      }
      System.out.println(builder);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
