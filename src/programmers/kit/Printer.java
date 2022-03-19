package programmers.kit;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Printer {
  public static void main(String[] args) {
    new Printer().solution(new int[]{2, 1, 3, 2}, 2);
    new Printer().solution(new int[]{1, 1, 9, 1, 1, 1}, 5);
    new Printer().solution(new int[]{3, 3, 3, 3}, 2);
  }

  private static class Order {
    private final int index;

    private final int value;

    private Order(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public int solution(int[] priorities, int location) {
    LinkedList<Order> queue = IntStream.range(0, priorities.length)
            .mapToObj(i -> new Order(i, priorities[i]))
            .collect(Collectors.toCollection(LinkedList::new));

    int count = 0;

    while (!queue.isEmpty()) {
      Order order = queue.poll();
      if (queue.stream().anyMatch(o -> o.value > order.value)) {
        queue.addLast(order);
        continue;
      }
      count++;
      if (order.value == priorities[location] && order.index == location) {
        break;
      }
    }

    return count;
  }
}
