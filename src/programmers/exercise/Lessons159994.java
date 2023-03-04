package programmers.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Lessons159994 {
  public static void main(String[] args) {
    System.out.println(new Lessons159994().solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    System.out.println(new Lessons159994().solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
  }

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    final var card1Queue = Arrays.stream(cards1).collect(Collectors.toCollection(LinkedList::new));
    final var card2Queue = Arrays.stream(cards2).collect(Collectors.toCollection(LinkedList::new));
    final var qoalQueue = Arrays.stream(goal).collect(Collectors.toCollection(LinkedList::new));
    while (!qoalQueue.isEmpty()) {
      final var g = qoalQueue.poll();
      if (!card1Queue.isEmpty() && card1Queue.peek().equals(g)) {
        card1Queue.poll();
      } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(g)) {
        card2Queue.poll();
      } else {
        return "No";
      }
    }
    return "Yes";
  }
}
