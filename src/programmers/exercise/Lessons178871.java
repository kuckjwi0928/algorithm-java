package programmers.exercise;

import java.util.Arrays;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class Lessons178871 {
  public static void main(String[] args) {
    final var obj = new Lessons178871();
    System.out.println(Arrays.toString(obj.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"})));
  }

  public String[] solution(String[] players, String[] callings) {
    final var orders = new HashMap<String, Integer>();
    for (var i = 0; i < players.length; i++) {
      orders.put(players[i], i);
    }
    for (String call : callings) {
      var currentOrder = orders.get(call);
      var nextOrder = currentOrder - 1;

      if (nextOrder < 0) {
        continue;
      }

      orders.put(players[currentOrder], nextOrder);
      orders.put(players[nextOrder], currentOrder);

      var temp = players[currentOrder];
      players[currentOrder] = players[nextOrder];
      players[nextOrder] = temp;
    }
    return players;
  }
}
