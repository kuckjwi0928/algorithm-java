package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution10845 {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      LinkedList<Integer> queue = new LinkedList<>();
      int N = Integer.parseInt(br.readLine());
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < N; i++) {
        String[] commands = br.readLine().split("\\s");
        switch (commands[0]) {
          case "push":
            queue.offer(Integer.parseInt(commands[1]));
            break;
          case "pop":
            builder.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
            break;
          case "size":
            builder.append(queue.size()).append('\n');
            break;
          case "front":
            builder.append(queue.isEmpty() ? -1 : queue.getFirst()).append('\n');
            break;
          case "back":
            builder.append(queue.isEmpty() ? -1 : queue.getLast()).append('\n');
            break;
          case "empty":
            builder.append(queue.isEmpty() ? 1 : 0).append('\n');
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
